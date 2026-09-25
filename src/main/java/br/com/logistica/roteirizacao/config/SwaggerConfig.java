package br.com.logistica.roteirizacao.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API de Roteirização Logística")
						.description("Cadastro de clientes, motoristas, veículos e entregas, com geração de rotas por proximidade.")
						.version("1.0.0")
						.contact(new Contact().name("Logística").email("contato@logistica.com.br")));
	}
}
