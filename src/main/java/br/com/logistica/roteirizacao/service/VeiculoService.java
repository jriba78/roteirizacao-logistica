package br.com.logistica.roteirizacao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logistica.roteirizacao.dto.VeiculoRequest;
import br.com.logistica.roteirizacao.dto.VeiculoResponse;
import br.com.logistica.roteirizacao.entity.Veiculo;
import br.com.logistica.roteirizacao.exception.BusinessException;
import br.com.logistica.roteirizacao.exception.ResourceNotFoundException;
import br.com.logistica.roteirizacao.mapper.DomainMapper;
import br.com.logistica.roteirizacao.repository.VeiculoRepository;

@Service
public class VeiculoService {

	private final VeiculoRepository repository;

	public VeiculoService(VeiculoRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public VeiculoResponse cadastrar(VeiculoRequest request) {
		String placa = normalizarPlaca(request.getPlaca());
		if (repository.existsByPlaca(placa)) {
			throw new BusinessException("Já existe veículo com esta placa");
		}
		Veiculo veiculo = new Veiculo();
		copiar(request, veiculo, placa);
		veiculo.setAtivo(request.getAtivo() == null || request.getAtivo());
		return DomainMapper.toResponse(repository.save(veiculo));
	}

	@Transactional(readOnly = true)
	public List<VeiculoResponse> listar() {
		return repository.findAll().stream().map(DomainMapper::toResponse).toList();
	}

	@Transactional(readOnly = true)
	public VeiculoResponse buscar(Long id) {
		return DomainMapper.toResponse(buscarEntidade(id));
	}

	@Transactional
	public VeiculoResponse atualizar(Long id, VeiculoRequest request) {
		Veiculo veiculo = buscarEntidade(id);
		String placa = normalizarPlaca(request.getPlaca());
		if (repository.existsByPlacaAndIdNot(placa, id)) {
			throw new BusinessException("Já existe veículo com esta placa");
		}
		copiar(request, veiculo, placa);
		if (request.getAtivo() != null) {
			veiculo.setAtivo(request.getAtivo());
		}
		return DomainMapper.toResponse(repository.save(veiculo));
	}

	@Transactional
	public void excluir(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Veículo não encontrado: " + id);
		}
		repository.deleteById(id);
	}

	public Veiculo buscarEntidade(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veículo não encontrado: " + id));
	}

	private void copiar(VeiculoRequest request, Veiculo veiculo, String placa) {
		veiculo.setPlaca(placa);
		veiculo.setModelo(request.getModelo());
		veiculo.setCapacidadePeso(request.getCapacidadePeso());
		veiculo.setCapacidadeEntregas(request.getCapacidadeEntregas());
	}

	private String normalizarPlaca(String placa) {
		return placa == null ? null : placa.replace(" ", "").toUpperCase();
	}
}
