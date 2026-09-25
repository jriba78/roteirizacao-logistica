package br.com.logistica.roteirizacao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.cd")
public class CentroDistribuicaoProperties {

	private double latitude;
	private double longitude;
	private double velocidadeMediaKmh = 30;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getVelocidadeMediaKmh() {
		return velocidadeMediaKmh;
	}

	public void setVelocidadeMediaKmh(double velocidadeMediaKmh) {
		this.velocidadeMediaKmh = velocidadeMediaKmh;
	}
}
