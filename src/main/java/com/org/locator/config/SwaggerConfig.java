package com.org.locator.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Satish Kumar T
 *
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SwaggerConfig {

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Atms Locator APIs").description("Spring boot micro service demo")
				.version("1.0").build();
	}

	@Bean
	public Docket seaggerSettings() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo()).globalOperationParameters(null).select()
				.paths(PathSelectors.any())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.apis(RequestHandlerSelectors.basePackage("com.org.locator.rest")).build();
	}
}
