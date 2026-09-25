package br.com.logistica.roteirizacao.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DistanciaService {

	private static final double RAIO_TERRA_KM = 6371.0;

	private DistanciaService() {
	}

	public static double haversineKm(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
				* Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return RAIO_TERRA_KM * c;
	}

	public static BigDecimal km(double valor) {
		return BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP);
	}
}
