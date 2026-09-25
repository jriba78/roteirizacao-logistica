package br.com.logistica.roteirizacao.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RotaRequest {

	@NotNull
	private Long motoristaId;

	@NotNull
	private Long veiculoId;

	@NotNull
	private LocalDate data;

	@NotEmpty
	private List<Long> entregaIds;

	public Long getMotoristaId() {
		return motoristaId;
	}

	public void setMotoristaId(Long motoristaId) {
		this.motoristaId = motoristaId;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Long> getEntregaIds() {
		return entregaIds;
	}

	public void setEntregaIds(List<Long> entregaIds) {
		this.entregaIds = entregaIds;
	}
}
