package br.com.logistica.roteirizacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.roteirizacao.dto.MotoristaRequest;
import br.com.logistica.roteirizacao.dto.MotoristaResponse;
import br.com.logistica.roteirizacao.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/motoristas")
@Tag(name = "Motoristas")
public class MotoristaController {

	private final MotoristaService service;

	public MotoristaController(MotoristaService service) {
		this.service = service;
	}

	@Operation(summary = "Cadastrar motorista")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MotoristaResponse cadastrar(@Valid @RequestBody MotoristaRequest request) {
		return service.cadastrar(request);
	}

	@Operation(summary = "Listar motoristas")
	@GetMapping
	public List<MotoristaResponse> listar() {
		return service.listar();
	}

	@Operation(summary = "Buscar motorista por ID")
	@GetMapping("/{id}")
	public MotoristaResponse buscar(@PathVariable Long id) {
		return service.buscar(id);
	}

	@Operation(summary = "Atualizar motorista")
	@PutMapping("/{id}")
	public MotoristaResponse atualizar(@PathVariable Long id, @Valid @RequestBody MotoristaRequest request) {
		return service.atualizar(id, request);
	}

	@Operation(summary = "Excluir motorista")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}
}
