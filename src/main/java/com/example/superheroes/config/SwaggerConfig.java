package com.example.superheroes.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${app.name}") String appName,
            @Value("${app.description}") String appDescription,
            @Value("${app.version}") String appVersion) { // these values are injected via @Value from application.properties
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(appName)
                        .version(appVersion)
                        .description(appDescription)
                        .license(new License().name("Apache 2.0").url("https://springdoc.org"))
                );
    }
}
