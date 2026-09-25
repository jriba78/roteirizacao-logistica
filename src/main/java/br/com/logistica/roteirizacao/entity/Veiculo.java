package br.com.logistica.roteirizacao.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 10)
	private String placa;

	@Column(nullable = false, length = 80)
	private String modelo;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal capacidadePeso;

	@Column(nullable = false)
	private Integer capacidadeEntregas;

	@Column(nullable = false)
	private boolean ativo = true;

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
