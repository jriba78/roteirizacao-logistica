package br.com.logistica.roteirizacao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.logistica.roteirizacao.domain.StatusRota;

public class RotaResponse {

	private Long id;
	private Long motoristaId;
	private String motoristaNome;
	private Long veiculoId;
	private String veiculoPlaca;
	private LocalDate data;
	private StatusRota status;
	private BigDecimal distanciaTotalKm;
	private Integer tempoEstimadoMinutos;
	private List<ParadaResponse> paradas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMotoristaId() {
		return motoristaId;
	}

	public void setMotoristaId(Long motoristaId) {
		this.motoristaId = motoristaId;
	}

	public String getMotoristaNome() {
		return motoristaNome;
	}

	public void setMotoristaNome(String motoristaNome) {
		this.motoristaNome = motoristaNome;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public String getVeiculoPlaca() {
		return veiculoPlaca;
	}

	public void setVeiculoPlaca(String veiculoPlaca) {
		this.veiculoPlaca = veiculoPlaca;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public StatusRota getStatus() {
		return status;
	}

	public void setStatus(StatusRota status) {
		this.status = status;
	}

	public BigDecimal getDistanciaTotalKm() {
		return distanciaTotalKm;
	}

	public void setDistanciaTotalKm(BigDecimal distanciaTotalKm) {
		this.distanciaTotalKm = distanciaTotalKm;
	}

	public Integer getTempoEstimadoMinutos() {
		return tempoEstimadoMinutos;
	}

	public void setTempoEstimadoMinutos(Integer tempoEstimadoMinutos) {
		this.tempoEstimadoMinutos = tempoEstimadoMinutos;
	}

	public List<ParadaResponse> getParadas() {
		return paradas;
	}

	public void setParadas(List<ParadaResponse> paradas) {
		this.paradas = paradas;
	}
}
