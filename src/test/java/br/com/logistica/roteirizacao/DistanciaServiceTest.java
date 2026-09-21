package br.com.logistica.roteirizacao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import br.com.logistica.roteirizacao.service.DistanciaService;

class DistanciaServiceTest {

	@Test
	void calculaDistanciaEntreDoisPontosDeSaoPaulo() {
		double km = DistanciaService.haversineKm(-23.55052, -46.633308, -23.5614, -46.6558);
		assertThat(km).isBetween(2.0, 4.0);
	}
}
