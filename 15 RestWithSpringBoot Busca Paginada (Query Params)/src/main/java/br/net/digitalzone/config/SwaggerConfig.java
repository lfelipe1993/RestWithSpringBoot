package br.net.digitalzone.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.net.digitalzone"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("RESTFul API with SpringBoot 2.1.3", 
				"Descrição API",
				"v1", 
				"Teres of Service Url", 
				new Contact("Luiz Felipe Mecina Greijo","www.digitalzone.net.br","contato@digitalzone.net.br"),
				"license of API", 
				"license of URL", Collections.emptyList());
	}
}
