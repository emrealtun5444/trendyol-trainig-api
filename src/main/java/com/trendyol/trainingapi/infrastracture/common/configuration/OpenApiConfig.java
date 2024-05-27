package com.trendyol.trainingapi.infrastracture.common.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import lombok.AllArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

@Configuration
@AllArgsConstructor
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Training Application")
                        .version("v1")
                        .description("Documentation of Training Application API"))
                .components(new Components()
                        .addParameters("Authorization", new Parameter()
                                .in("header")
                                .name("Authorization")
                                .description("Token required for authentication")
                                .required(false)
                                .schema(new Schema().type("string")))
                        .addParameters("SessionId", new Parameter()
                                .in("header")
                                .name("SessionId")
                                .description("Session ID for app")
                                .required(false)
                                .schema(new Schema().type("string")))
                );
    }

    @Bean
    public OpenApiCustomizer addGlobalParameters() {
        return openApi -> openApi.getPaths().forEach((path, pathItem) -> pathItem.readOperations().forEach(operation -> {
            operation.addParametersItem(new Parameter().$ref("#/components/parameters/Authorization"));
            operation.addParametersItem(new Parameter().$ref("#/components/parameters/SessionId"));
        }));
    }
}