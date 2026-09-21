package br.com.logistica.roteirizacao.dto;

import br.com.logistica.roteirizacao.domain.StatusRota;
import jakarta.validation.constraints.NotNull;

public class AtualizarStatusRotaRequest {

	@NotNull
	private StatusRota status;

	public StatusRota getStatus() {
		return status;
	}

	public void setStatus(StatusRota status) {
		this.status = status;
	}
}
