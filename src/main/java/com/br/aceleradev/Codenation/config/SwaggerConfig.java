package com.br.aceleradev.Codenation.config;

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
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.br.aceleradev.Codenation.controller"))
				.paths(PathSelectors.regex( "/.*"))
				.build().apiInfo(apiInfo());
				
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"APPLICATION API",
				"Nossa Aplicação da Codenation",
				"1.0.0-RELEASE",
				"Terms of service",
				new Contact("Jarison Araujo", "https://www.linkedin.com/jarison", "jarisonaraujo@gmail.com"),
				"License API",
				"License URL",
				Collections.emptyList());
	}

}
