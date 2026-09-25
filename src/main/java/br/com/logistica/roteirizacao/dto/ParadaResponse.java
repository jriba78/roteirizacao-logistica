package br.com.logistica.roteirizacao.dto;

import java.math.BigDecimal;

public class ParadaResponse {

	private Long id;
	private Integer sequencia;
	private Long entregaId;
	private String endereco;
	private String cidade;
	private Double latitude;
	private Double longitude;
	private BigDecimal distanciaDoPontoAnteriorKm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public Long getEntregaId() {
		return entregaId;
	}

	public void setEntregaId(Long entregaId) {
		this.entregaId = entregaId;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getDistanciaDoPontoAnteriorKm() {
		return distanciaDoPontoAnteriorKm;
	}

	public void setDistanciaDoPontoAnteriorKm(BigDecimal distanciaDoPontoAnteriorKm) {
		this.distanciaDoPontoAnteriorKm = distanciaDoPontoAnteriorKm;
	}
}
