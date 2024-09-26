package br.com.mariolemos.gestaoEscolar;

import br.com.mariolemos.gestaoEscolar.model.Pessoa;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestaoEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoEscolarApplication.class, args);
	}

	@Bean
	public GroupedOpenApi groupedOpenApi() {
		return GroupedOpenApi.builder()
				.group("api")
				.pathsToMatch("/api/**")
				.build();
	}
//	@Bean
//	public SwaggerUiConfigParameters swaggerUiConfigParameters() {
//		return new SwaggerUiConfigParameters()
//				.addSwaggerUiConfig(
//						new SwaggerUiConfig().setDeepLinking(true).setDisplayOperationId(true))
//				.setValidatorUrl(null);
// 	}

}

