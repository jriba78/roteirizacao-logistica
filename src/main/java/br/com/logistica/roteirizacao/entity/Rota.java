package br.com.logistica.roteirizacao.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.logistica.roteirizacao.domain.StatusRota;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "rotas")
public class Rota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "motorista_id")
	private Motorista motorista;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	@Column(nullable = false)
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private StatusRota status = StatusRota.PLANEJADA;

	@Column(precision = 12, scale = 2)
	private BigDecimal distanciaTotalKm;

	private Integer tempoEstimadoMinutos;

	@OneToMany(mappedBy = "rota", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("sequencia ASC")
	private List<Parada> paradas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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

	public List<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}
}
