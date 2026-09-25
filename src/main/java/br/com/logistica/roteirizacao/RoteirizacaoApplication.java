package br.com.logistica.roteirizacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.logistica.roteirizacao.config.CentroDistribuicaoProperties;

@SpringBootApplication
@EnableConfigurationProperties(CentroDistribuicaoProperties.class)
public class RoteirizacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoteirizacaoApplication.class, args);
	}
}
