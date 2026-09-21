package br.com.logistica.roteirizacao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logistica.roteirizacao.domain.StatusEntrega;
import br.com.logistica.roteirizacao.dto.AtualizarStatusEntregaRequest;
import br.com.logistica.roteirizacao.dto.EntregaRequest;
import br.com.logistica.roteirizacao.dto.EntregaResponse;
import br.com.logistica.roteirizacao.entity.Cliente;
import br.com.logistica.roteirizacao.entity.Entrega;
import br.com.logistica.roteirizacao.exception.ResourceNotFoundException;
import br.com.logistica.roteirizacao.mapper.DomainMapper;
import br.com.logistica.roteirizacao.repository.EntregaRepository;

@Service
public class EntregaService {

	private final EntregaRepository repository;
	private final ClienteService clienteService;

	public EntregaService(EntregaRepository repository, ClienteService clienteService) {
		this.repository = repository;
		this.clienteService = clienteService;
	}

	@Transactional
	public EntregaResponse cadastrar(EntregaRequest request) {
		Cliente cliente = clienteService.buscarEntidade(request.getClienteId());
		Entrega entrega = new Entrega();
		copiar(request, entrega, cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		return DomainMapper.toResponse(repository.save(entrega));
	}

	@Transactional(readOnly = true)
	public List<EntregaResponse> listar() {
		return repository.findAll().stream().map(DomainMapper::toResponse).toList();
	}

	@Transactional(readOnly = true)
	public EntregaResponse buscar(Long id) {
		return DomainMapper.toResponse(buscarEntidade(id));
	}

	@Transactional
	public EntregaResponse atualizar(Long id, EntregaRequest request) {
		Entrega entrega = buscarEntidade(id);
		Cliente cliente = clienteService.buscarEntidade(request.getClienteId());
		copiar(request, entrega, cliente);
		return DomainMapper.toResponse(repository.save(entrega));
	}

	@Transactional
	public EntregaResponse atualizarStatus(Long id, AtualizarStatusEntregaRequest request) {
		Entrega entrega = buscarEntidade(id);
		entrega.setStatus(request.getStatus());
		return DomainMapper.toResponse(repository.save(entrega));
	}

	@Transactional
	public void excluir(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Entrega não encontrada: " + id);
		}
		repository.deleteById(id);
	}

	public Entrega buscarEntidade(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entrega não encontrada: " + id));
	}

	private void copiar(EntregaRequest request, Entrega entrega, Cliente cliente) {
		entrega.setCliente(cliente);
		entrega.setEndereco(request.getEndereco());
		entrega.setCidade(request.getCidade());
		entrega.setCep(request.getCep());
		entrega.setLatitude(request.getLatitude());
		entrega.setLongitude(request.getLongitude());
		entrega.setPeso(request.getPeso());
		entrega.setObservacao(request.getObservacao());
	}
}
