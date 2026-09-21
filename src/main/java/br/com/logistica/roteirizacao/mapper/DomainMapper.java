package br.com.logistica.roteirizacao.mapper;

import br.com.logistica.roteirizacao.dto.EntregaResponse;
import br.com.logistica.roteirizacao.dto.MotoristaResponse;
import br.com.logistica.roteirizacao.dto.ParadaResponse;
import br.com.logistica.roteirizacao.dto.RotaResponse;
import br.com.logistica.roteirizacao.dto.VeiculoResponse;
import br.com.logistica.roteirizacao.entity.Entrega;
import br.com.logistica.roteirizacao.entity.Motorista;
import br.com.logistica.roteirizacao.entity.Parada;
import br.com.logistica.roteirizacao.entity.Rota;
import br.com.logistica.roteirizacao.entity.Veiculo;

public final class DomainMapper {

	private DomainMapper() {
	}

	public static MotoristaResponse toResponse(Motorista motorista) {
		MotoristaResponse response = new MotoristaResponse();
		response.setId(motorista.getId());
		response.setNome(motorista.getNome());
		response.setCnh(motorista.getCnh());
		response.setTelefone(motorista.getTelefone());
		response.setAtivo(motorista.isAtivo());
		return response;
	}

	public static VeiculoResponse toResponse(Veiculo veiculo) {
		VeiculoResponse response = new VeiculoResponse();
		response.setId(veiculo.getId());
		response.setPlaca(veiculo.getPlaca());
		response.setModelo(veiculo.getModelo());
		response.setCapacidadePeso(veiculo.getCapacidadePeso());
		response.setCapacidadeEntregas(veiculo.getCapacidadeEntregas());
		response.setAtivo(veiculo.isAtivo());
		return response;
	}

	public static EntregaResponse toResponse(Entrega entrega) {
		EntregaResponse response = new EntregaResponse();
		response.setId(entrega.getId());
		response.setClienteId(entrega.getCliente().getId());
		response.setClienteNome(entrega.getCliente().getNome());
		response.setEndereco(entrega.getEndereco());
		response.setCidade(entrega.getCidade());
		response.setCep(entrega.getCep());
		response.setLatitude(entrega.getLatitude());
		response.setLongitude(entrega.getLongitude());
		response.setPeso(entrega.getPeso());
		response.setStatus(entrega.getStatus());
		response.setObservacao(entrega.getObservacao());
		return response;
	}

	public static RotaResponse toResponse(Rota rota) {
		RotaResponse response = new RotaResponse();
		response.setId(rota.getId());
		response.setMotoristaId(rota.getMotorista().getId());
		response.setMotoristaNome(rota.getMotorista().getNome());
		response.setVeiculoId(rota.getVeiculo().getId());
		response.setVeiculoPlaca(rota.getVeiculo().getPlaca());
		response.setData(rota.getData());
		response.setStatus(rota.getStatus());
		response.setDistanciaTotalKm(rota.getDistanciaTotalKm());
		response.setTempoEstimadoMinutos(rota.getTempoEstimadoMinutos());
		response.setParadas(rota.getParadas().stream().map(DomainMapper::toResponse).toList());
		return response;
	}

	public static ParadaResponse toResponse(Parada parada) {
		ParadaResponse response = new ParadaResponse();
		response.setId(parada.getId());
		response.setSequencia(parada.getSequencia());
		response.setEntregaId(parada.getEntrega().getId());
		response.setEndereco(parada.getEntrega().getEndereco());
		response.setCidade(parada.getEntrega().getCidade());
		response.setLatitude(parada.getEntrega().getLatitude());
		response.setLongitude(parada.getEntrega().getLongitude());
		response.setDistanciaDoPontoAnteriorKm(parada.getDistanciaDoPontoAnteriorKm());
		return response;
	}
}
