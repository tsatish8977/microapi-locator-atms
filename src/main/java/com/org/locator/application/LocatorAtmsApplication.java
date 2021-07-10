package com.org.locator.application;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, ErrorMvcAutoConfiguration.class })
@SpringBootApplication
@ComponentScan(basePackages = "com.org.locator")
public class LocatorAtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocatorAtmsApplication.class);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		//return builder.messageConverters(Collections.singletonList(mappingJackson2HttpMessageConverter())).build();
	}

	/*
	 * @Bean public MappingJackson2HttpMessageConverter
	 * mappingJackson2HttpMessageConverter() { MappingJackson2HttpMessageConverter
	 * jacksonConverter = new MappingJackson2HttpMessageConverter(); ObjectMapper
	 * objMapper = jacksonBuilder().build();
	 * jacksonConverter.setObjectMapper(objMapper); return jacksonConverter; }
	 */

	/*
	 * @Bean public Jackson2ObjectMapperBuilder jacksonBuilder() { return new
	 * Jackson2ObjectMapperBuilder().serializationInclusion(JsonInclude.Include.
	 * NON_NULL) .failOnUnknownProperties(false); }
	 */
}
