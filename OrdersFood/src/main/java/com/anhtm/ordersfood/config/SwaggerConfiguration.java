package com.anhtm.ordersfood.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * The type Swagger configuration.
 */
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info())
@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfiguration {

    /**
     * Api open api.
     *
     * @return the open api
     */
    public OpenAPI api() {
      return new OpenAPI()
        .info(new Info()
        .title("Order food API - Aug")
        .description("Order food Spring Framework Application")
        .version("v3")
        .license(new License()
        .name("Apache 2.0")
        .url("http://springdoc.org")))
        .externalDocs(new ExternalDocumentation());
    }
}
