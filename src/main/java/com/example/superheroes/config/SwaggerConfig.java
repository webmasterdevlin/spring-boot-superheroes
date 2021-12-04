package com.example.superheroes.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components())
            .info(new Info()
                    .title("Superheroes API")
                    .version("1.0.0")
                    .description("just another sample of Spring Boot")
                    .license(new License().name("Apache 2.0").url("https://springdoc.org"))
            );
  }
}
