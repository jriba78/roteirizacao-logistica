package br.com.logistica.roteirizacao.dto;

import java.math.BigDecimal;

public class VeiculoResponse {

	private Long id;
	private String placa;
	private String modelo;
	private BigDecimal capacidadePeso;
	private Integer capacidadeEntregas;
	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
