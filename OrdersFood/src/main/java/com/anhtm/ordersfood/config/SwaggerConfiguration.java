package com.anhtm.ordersfood.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableAutoConfiguration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI api() {
      return new OpenAPI()
        .info(new Info()
        .title("Order food API - Aug")
        .description("Order food Spring Framework Application")
        .version("v0.0.1")
        .license(new License()
        .name("Apache 2.0")
        .url("http://springdoc.org")))
        .externalDocs(new ExternalDocumentation());
    }
}
