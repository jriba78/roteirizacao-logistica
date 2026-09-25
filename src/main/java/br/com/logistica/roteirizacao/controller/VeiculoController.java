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

import br.com.logistica.roteirizacao.dto.VeiculoRequest;
import br.com.logistica.roteirizacao.dto.VeiculoResponse;
import br.com.logistica.roteirizacao.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/veiculos")
@Tag(name = "Veículos")
public class VeiculoController {

	private final VeiculoService service;

	public VeiculoController(VeiculoService service) {
		this.service = service;
	}

	@Operation(summary = "Cadastrar veículo")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VeiculoResponse cadastrar(@Valid @RequestBody VeiculoRequest request) {
		return service.cadastrar(request);
	}

	@Operation(summary = "Listar veículos")
	@GetMapping
	public List<VeiculoResponse> listar() {
		return service.listar();
	}

	@Operation(summary = "Buscar veículo por ID")
	@GetMapping("/{id}")
	public VeiculoResponse buscar(@PathVariable Long id) {
		return service.buscar(id);
	}

	@Operation(summary = "Atualizar veículo")
	@PutMapping("/{id}")
	public VeiculoResponse atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoRequest request) {
		return service.atualizar(id, request);
	}

	@Operation(summary = "Excluir veículo")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}
}
