package br.com.logistica.roteirizacao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logistica.roteirizacao.dto.ClienteRequest;
import br.com.logistica.roteirizacao.dto.ClienteResponse;
import br.com.logistica.roteirizacao.entity.Cliente;
import br.com.logistica.roteirizacao.exception.BusinessException;
import br.com.logistica.roteirizacao.exception.ResourceNotFoundException;
import br.com.logistica.roteirizacao.mapper.ClienteMapper;
import br.com.logistica.roteirizacao.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository repository;

	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public ClienteResponse cadastrar(ClienteRequest request) {
		if (repository.existsByEmail(request.getEmail())) {
			throw new BusinessException("Já existe cliente com este e-mail");
		}
		Cliente cliente = new Cliente();
		ClienteMapper.copiar(request, cliente);
		return ClienteMapper.toResponse(repository.save(cliente));
	}

	@Transactional(readOnly = true)
	public List<ClienteResponse> listar() {
		return repository.findAll().stream().map(ClienteMapper::toResponse).toList();
	}

	@Transactional(readOnly = true)
	public ClienteResponse buscar(Long id) {
		return ClienteMapper.toResponse(buscarEntidade(id));
	}

	@Transactional
	public ClienteResponse atualizar(Long id, ClienteRequest request) {
		Cliente cliente = buscarEntidade(id);
		if (repository.existsByEmailAndIdNot(request.getEmail(), id)) {
			throw new BusinessException("Já existe cliente com este e-mail");
		}
		ClienteMapper.copiar(request, cliente);
		return ClienteMapper.toResponse(repository.save(cliente));
	}

	@Transactional
	public void excluir(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Cliente não encontrado: " + id);
		}
		repository.deleteById(id);
	}

	public Cliente buscarEntidade(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado: " + id));
	}
}
