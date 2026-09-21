package br.com.logistica.roteirizacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.roteirizacao.dto.AtualizarStatusEntregaRequest;
import br.com.logistica.roteirizacao.dto.EntregaRequest;
import br.com.logistica.roteirizacao.dto.EntregaResponse;
import br.com.logistica.roteirizacao.service.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/entregas")
@Tag(name = "Entregas")
public class EntregaController {

	private final EntregaService service;

	public EntregaController(EntregaService service) {
		this.service = service;
	}

	@Operation(summary = "Cadastrar entrega")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaResponse cadastrar(@Valid @RequestBody EntregaRequest request) {
		return service.cadastrar(request);
	}

	@Operation(summary = "Listar entregas")
	@GetMapping
	public List<EntregaResponse> listar() {
		return service.listar();
	}

	@Operation(summary = "Buscar entrega por ID")
	@GetMapping("/{id}")
	public EntregaResponse buscar(@PathVariable Long id) {
		return service.buscar(id);
	}

	@Operation(summary = "Atualizar entrega")
	@PutMapping("/{id}")
	public EntregaResponse atualizar(@PathVariable Long id, @Valid @RequestBody EntregaRequest request) {
		return service.atualizar(id, request);
	}

	@Operation(summary = "Atualizar status da entrega")
	@PatchMapping("/{id}/status")
	public EntregaResponse atualizarStatus(@PathVariable Long id,
			@Valid @RequestBody AtualizarStatusEntregaRequest request) {
		return service.atualizarStatus(id, request);
	}

	@Operation(summary = "Excluir entrega")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}
}
