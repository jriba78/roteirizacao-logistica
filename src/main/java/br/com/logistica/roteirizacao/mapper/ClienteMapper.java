package br.com.logistica.roteirizacao.mapper;

import br.com.logistica.roteirizacao.dto.ClienteRequest;
import br.com.logistica.roteirizacao.dto.ClienteResponse;
import br.com.logistica.roteirizacao.entity.Cliente;

public final class ClienteMapper {

	private ClienteMapper() {
	}

	public static void copiar(ClienteRequest request, Cliente cliente) {
		cliente.setNome(request.getNome());
		cliente.setEmail(request.getEmail());
		cliente.setTelefone(request.getTelefone());
		cliente.setEndereco(request.getEndereco());
		cliente.setCidade(request.getCidade());
		cliente.setCep(request.getCep());
		cliente.setLatitude(request.getLatitude());
		cliente.setLongitude(request.getLongitude());
	}

	public static ClienteResponse toResponse(Cliente cliente) {
		ClienteResponse response = new ClienteResponse();
		response.setId(cliente.getId());
		response.setNome(cliente.getNome());
		response.setEmail(cliente.getEmail());
		response.setTelefone(cliente.getTelefone());
		response.setEndereco(cliente.getEndereco());
		response.setCidade(cliente.getCidade());
		response.setCep(cliente.getCep());
		response.setLatitude(cliente.getLatitude());
		response.setLongitude(cliente.getLongitude());
		return response;
	}
}
