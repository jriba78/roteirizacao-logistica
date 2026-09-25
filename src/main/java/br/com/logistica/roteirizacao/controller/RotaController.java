package br.com.logistica.roteirizacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.roteirizacao.dto.AtualizarStatusRotaRequest;
import br.com.logistica.roteirizacao.dto.RotaRequest;
import br.com.logistica.roteirizacao.dto.RotaResponse;
import br.com.logistica.roteirizacao.service.RotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rotas")
@Tag(name = "Rotas e roteirização")
public class RotaController {

	private final RotaService service;

	public RotaController(RotaService service) {
		this.service = service;
	}

	@Operation(summary = "Criar rota e ordenar paradas por proximidade")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RotaResponse criar(@Valid @RequestBody RotaRequest request) {
		return service.criar(request);
	}

	@Operation(summary = "Listar rotas")
	@GetMapping
	public List<RotaResponse> listar() {
		return service.listar();
	}

	@Operation(summary = "Buscar rota por ID")
	@GetMapping("/{id}")
	public RotaResponse buscar(@PathVariable Long id) {
		return service.buscar(id);
	}

	@Operation(summary = "Atualizar status da rota (EM_ANDAMENTO, CONCLUIDA, CANCELADA)")
	@PatchMapping("/{id}/status")
	public RotaResponse atualizarStatus(@PathVariable Long id, @Valid @RequestBody AtualizarStatusRotaRequest request) {
		return service.atualizarStatus(id, request);
	}
}
