package com.portfoliobackend.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static com.portfoliobackend.infrastructure.config.Constants.*;


@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openApiConfig() {
        Schema<?> messageSchema = new Schema<Map<String, String>>()
                .addProperty(RESPONSE_MESSAGE_KEY, new StringSchema().description(DESCRIPTION_MESSAGE_KEY).example("string"));
        Schema<?> messageBoleanSchema = new Schema<Map<String, String>>()
                .addProperty(RESPONSE_MESSAGE_KEY, new StringSchema().description(DESCRIPTION_MESSAGE_BOOLEAN_KEY).example("boolean"));
        Schema<?> errorSchema = new Schema<Map<String, String>>()
                .addProperty(RESPONSE_ERROR_MESSAGE_KEY, new StringSchema().description(DESCRIPTION_ERROR_KEY).example("string"));
        return new OpenAPI()
                .info(new Info()
                        .title(Constants.SWAGGER_TITLE_MESSAGE)
                        .description(Constants.SWAGGER_DESCRIPTION_MESSAGE)
                        .version(Constants.SWAGGER_VERSION_MESSAGE)
                        .license(new License().name(Constants.SWAGGER_LICENSE_NAME_MESSAGE).url(Constants.SWAGGER_LICENSE_URL_MESSAGE))
                        .termsOfService(Constants.SWAGGER_TERMS_OF_SERVICE_MESSAGE))
                .components(new Components()
                        .addSchemas("Message", messageSchema)
                        .addSchemas("MessageBoolean", messageBoleanSchema)
                        .addSchemas("Error", errorSchema));

    }
}
