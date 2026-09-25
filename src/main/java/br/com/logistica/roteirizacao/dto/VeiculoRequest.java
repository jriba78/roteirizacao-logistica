package br.com.logistica.roteirizacao.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VeiculoRequest {

	@NotBlank
	@Size(max = 10)
	private String placa;

	@NotBlank
	@Size(max = 80)
	private String modelo;

	@NotNull
	@DecimalMin("0.01")
	private BigDecimal capacidadePeso;

	@NotNull
	@Min(1)
	private Integer capacidadeEntregas;

	private Boolean ativo;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getCapacidadePeso() {
		return capacidadePeso;
	}

	public void setCapacidadePeso(BigDecimal capacidadePeso) {
		this.capacidadePeso = capacidadePeso;
	}

	public Integer getCapacidadeEntregas() {
		return capacidadeEntregas;
	}

	public void setCapacidadeEntregas(Integer capacidadeEntregas) {
		this.capacidadeEntregas = capacidadeEntregas;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
