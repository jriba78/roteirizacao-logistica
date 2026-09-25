package br.com.logistica.roteirizacao.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paradas")
public class Parada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "rota_id")
	private Rota rota;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "entrega_id")
	private Entrega entrega;

	@Column(nullable = false)
	private Integer sequencia;

	@Column(precision = 12, scale = 2)
	private BigDecimal distanciaDoPontoAnteriorKm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public BigDecimal getDistanciaDoPontoAnteriorKm() {
		return distanciaDoPontoAnteriorKm;
	}

	public void setDistanciaDoPontoAnteriorKm(BigDecimal distanciaDoPontoAnteriorKm) {
		this.distanciaDoPontoAnteriorKm = distanciaDoPontoAnteriorKm;
	}
}
