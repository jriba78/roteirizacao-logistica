package br.com.logistica.roteirizacao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logistica.roteirizacao.dto.MotoristaRequest;
import br.com.logistica.roteirizacao.dto.MotoristaResponse;
import br.com.logistica.roteirizacao.entity.Motorista;
import br.com.logistica.roteirizacao.exception.BusinessException;
import br.com.logistica.roteirizacao.exception.ResourceNotFoundException;
import br.com.logistica.roteirizacao.mapper.DomainMapper;
import br.com.logistica.roteirizacao.repository.MotoristaRepository;

@Service
public class MotoristaService {

	private final MotoristaRepository repository;

	public MotoristaService(MotoristaRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public MotoristaResponse cadastrar(MotoristaRequest request) {
		if (repository.existsByCnh(request.getCnh())) {
			throw new BusinessException("Já existe motorista com esta CNH");
		}
		Motorista motorista = new Motorista();
		copiar(request, motorista);
		motorista.setAtivo(request.getAtivo() == null || request.getAtivo());
		return DomainMapper.toResponse(repository.save(motorista));
	}

	@Transactional(readOnly = true)
	public List<MotoristaResponse> listar() {
		return repository.findAll().stream().map(DomainMapper::toResponse).toList();
	}

	@Transactional(readOnly = true)
	public MotoristaResponse buscar(Long id) {
		return DomainMapper.toResponse(buscarEntidade(id));
	}

	@Transactional
	public MotoristaResponse atualizar(Long id, MotoristaRequest request) {
		Motorista motorista = buscarEntidade(id);
		if (repository.existsByCnhAndIdNot(request.getCnh(), id)) {
			throw new BusinessException("Já existe motorista com esta CNH");
		}
		copiar(request, motorista);
		if (request.getAtivo() != null) {
			motorista.setAtivo(request.getAtivo());
		}
		return DomainMapper.toResponse(repository.save(motorista));
	}

	@Transactional
	public void excluir(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Motorista não encontrado: " + id);
		}
		repository.deleteById(id);
	}

	public Motorista buscarEntidade(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado: " + id));
	}

	private void copiar(MotoristaRequest request, Motorista motorista) {
		motorista.setNome(request.getNome());
		motorista.setCnh(request.getCnh());
		motorista.setTelefone(request.getTelefone());
	}
}
