package com.fis.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OpenApiConfig {

	@Bean
	public OpenAPI openAPI(@Value("${kakaopaysec-api.version}") String appVersion,
			@Value("${kakaopaysec-api.url}") String url, @Value("${spring.profiles.active}") String active) {
		Info info = new Info().title("fis API - " + active).version(appVersion)
				.description("fis API 입니다.")
				.termsOfService("http://swagger.io/terms/")
				.contact(new Contact().name("fis").url("https://www.yun.co.kr").email("dbsckd512@naver.co.kr"))
				.license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));
		
		List<Server> servers = Arrays.asList(new Server().url(url).description("demo (" + active +")"));


		SecurityScheme securityScheme = new SecurityScheme()
				.type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
				.in(SecurityScheme.In.HEADER).name("Authorization");
		SecurityRequirement schemaRequirement = new SecurityRequirement().addList("bearerAuth");

		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
				.addSecurityItem(schemaRequirement)
				.security(Arrays.asList(schemaRequirement))
				.info(info)
				.servers(servers);

	}
	
}