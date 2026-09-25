package br.com.logistica.roteirizacao.dto;

import br.com.logistica.roteirizacao.domain.StatusEntrega;
import jakarta.validation.constraints.NotNull;

public class AtualizarStatusEntregaRequest {

	@NotNull
	private StatusEntrega status;

	public StatusEntrega getStatus() {
		return status;
	}

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}
}
