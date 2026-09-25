package br.com.logistica.roteirizacao.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logistica.roteirizacao.config.CentroDistribuicaoProperties;
import br.com.logistica.roteirizacao.domain.StatusEntrega;
import br.com.logistica.roteirizacao.domain.StatusRota;
import br.com.logistica.roteirizacao.dto.AtualizarStatusRotaRequest;
import br.com.logistica.roteirizacao.dto.RotaRequest;
import br.com.logistica.roteirizacao.dto.RotaResponse;
import br.com.logistica.roteirizacao.entity.Entrega;
import br.com.logistica.roteirizacao.entity.Motorista;
import br.com.logistica.roteirizacao.entity.Parada;
import br.com.logistica.roteirizacao.entity.Rota;
import br.com.logistica.roteirizacao.entity.Veiculo;
import br.com.logistica.roteirizacao.exception.BusinessException;
import br.com.logistica.roteirizacao.exception.ResourceNotFoundException;
import br.com.logistica.roteirizacao.mapper.DomainMapper;
import br.com.logistica.roteirizacao.repository.EntregaRepository;
import br.com.logistica.roteirizacao.repository.RotaRepository;

@Service
public class RotaService {

	private final RotaRepository rotaRepository;
	private final EntregaRepository entregaRepository;
	private final MotoristaService motoristaService;
	private final VeiculoService veiculoService;
	private final CentroDistribuicaoProperties cd;

	public RotaService(RotaRepository rotaRepository, EntregaRepository entregaRepository,
			MotoristaService motoristaService, VeiculoService veiculoService, CentroDistribuicaoProperties cd) {
		this.rotaRepository = rotaRepository;
		this.entregaRepository = entregaRepository;
		this.motoristaService = motoristaService;
		this.veiculoService = veiculoService;
		this.cd = cd;
	}

	@Transactional
	public RotaResponse criar(RotaRequest request) {
		Motorista motorista = motoristaService.buscarEntidade(request.getMotoristaId());
		Veiculo veiculo = veiculoService.buscarEntidade(request.getVeiculoId());
		validarDisponibilidade(motorista, veiculo);

		List<Entrega> entregas = carregarEntregas(request.getEntregaIds());
		validarCapacidade(veiculo, entregas);

		Rota rota = new Rota();
		rota.setMotorista(motorista);
		rota.setVeiculo(veiculo);
		rota.setData(request.getData());
		rota.setStatus(StatusRota.PLANEJADA);
		montarParadasPorProximidade(rota, entregas);

		Rota salva = rotaRepository.save(rota);
		return DomainMapper.toResponse(rotaRepository.findById(salva.getId()).orElse(salva));
	}

	@Transactional(readOnly = true)
	public List<RotaResponse> listar() {
		return rotaRepository.findAll().stream().map(DomainMapper::toResponse).toList();
	}

	@Transactional(readOnly = true)
	public RotaResponse buscar(Long id) {
		return DomainMapper.toResponse(buscarEntidade(id));
	}

	@Transactional
	public RotaResponse atualizarStatus(Long id, AtualizarStatusRotaRequest request) {
		Rota rota = buscarEntidade(id);
		rota.setStatus(request.getStatus());
		if (request.getStatus() == StatusRota.EM_ANDAMENTO) {
			rota.getParadas().forEach(p -> p.getEntrega().setStatus(StatusEntrega.EM_ROTA));
		}
		if (request.getStatus() == StatusRota.CONCLUIDA) {
			rota.getParadas().forEach(p -> p.getEntrega().setStatus(StatusEntrega.ENTREGUE));
		}
		if (request.getStatus() == StatusRota.CANCELADA) {
			rota.getParadas().forEach(p -> p.getEntrega().setStatus(StatusEntrega.PENDENTE));
		}
		return DomainMapper.toResponse(rotaRepository.save(rota));
	}

	private Rota buscarEntidade(Long id) {
		return rotaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rota não encontrada: " + id));
	}

	private void validarDisponibilidade(Motorista motorista, Veiculo veiculo) {
		if (!motorista.isAtivo()) {
			throw new BusinessException("Motorista inativo");
		}
		if (!veiculo.isAtivo()) {
			throw new BusinessException("Veículo inativo");
		}
	}

	private List<Entrega> carregarEntregas(List<Long> ids) {
		Set<Long> unicos = new HashSet<>(ids);
		List<Entrega> entregas = new ArrayList<>();
		for (Long id : unicos) {
			Entrega entrega = entregaRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Entrega não encontrada: " + id));
			if (entrega.getStatus() != StatusEntrega.PENDENTE) {
				throw new BusinessException("Somente entregas PENDENTE podem entrar na rota: " + id);
			}
			entregas.add(entrega);
		}
		return entregas;
	}

	private void validarCapacidade(Veiculo veiculo, List<Entrega> entregas) {
		if (entregas.size() > veiculo.getCapacidadeEntregas()) {
			throw new BusinessException("Quantidade de entregas excede a capacidade do veículo");
		}
		BigDecimal pesoTotal = entregas.stream()
				.map(Entrega::getPeso)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		if (pesoTotal.compareTo(veiculo.getCapacidadePeso()) > 0) {
			throw new BusinessException("Peso total das entregas excede a capacidade do veículo");
		}
	}

	private void montarParadasPorProximidade(Rota rota, List<Entrega> pendentes) {
		List<Entrega> restantes = new ArrayList<>(pendentes);
		double atualLat = cd.getLatitude();
		double atualLon = cd.getLongitude();
		double distanciaTotal = 0;
		int sequencia = 1;
		rota.getParadas().clear();

		while (!restantes.isEmpty()) {
			Entrega maisProxima = null;
			double menor = Double.MAX_VALUE;
			for (Entrega entrega : restantes) {
				double dist = DistanciaService.haversineKm(atualLat, atualLon, entrega.getLatitude(),
						entrega.getLongitude());
				if (dist < menor) {
					menor = dist;
					maisProxima = entrega;
				}
			}
			Parada parada = new Parada();
			parada.setRota(rota);
			parada.setEntrega(maisProxima);
			parada.setSequencia(sequencia++);
			parada.setDistanciaDoPontoAnteriorKm(DistanciaService.km(menor));
			rota.getParadas().add(parada);
			maisProxima.setStatus(StatusEntrega.EM_ROTA);
			distanciaTotal += menor;
			atualLat = maisProxima.getLatitude();
			atualLon = maisProxima.getLongitude();
			restantes.remove(maisProxima);
		}

		double retorno = DistanciaService.haversineKm(atualLat, atualLon, cd.getLatitude(), cd.getLongitude());
		distanciaTotal += retorno;
		rota.setDistanciaTotalKm(DistanciaService.km(distanciaTotal));
		double horas = distanciaTotal / Math.max(cd.getVelocidadeMediaKmh(), 1);
		rota.setTempoEstimadoMinutos((int) Math.round(horas * 60));
	}
}
