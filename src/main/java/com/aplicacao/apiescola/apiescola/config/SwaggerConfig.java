package com.aplicacao.apiescola.apiescola.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket escolaApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.aplicacao.apiescola"))
				.paths(PathSelectors.regex("/alunos.*"))
				.build()
				.apiInfo(metaInfo());
	}
	

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Escola API REST",
				"API REST de cadastro de turmas e alunos.",
				"1.0",
				"Termos of Service",
				new Contact("Bruno Marinho", "https://www.google.com", "brunomarinho06@hotmail.com"),
				"Apache Licence Version 2.0",
				"https://www.apache.org/licensen.html", new ArrayList<VendorExtension>());
		
		return apiInfo;
		
	
	}

}
