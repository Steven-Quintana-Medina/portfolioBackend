package com.portfoliobackend.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProjectReqDto {
    @NotBlank
    @Schema(name = "name", description = "name of a project", example = "small square microsercice")
    private String name;
    @NotBlank
    @Schema(name = "description", description = "description of a project", example = "This is a microservice in charge of centralizing orders from a small square that has different restaurants, each with a particular menu")
    private String description;
    @NotBlank
    @Schema(name = "technologies", description = "technologies used in the project", example = "Spring boot - MySql - JWT - Swagger - Gradle - feing")
    private String technologies;
    @NotBlank
    @Schema(name = "image", description = "image url", example = "https://media-cdn.tripadvisor.com/media/photo-s/14/8b/1a/61/plazoleta-de-comidas.jpg")
    private String image;
    @NotBlank
    @Schema(name = "link", description = "url where the project is deployed", example = "https://small-square-app.onrender.com")
    private String link;
    @NotBlank
    @Schema(name = "userCode", description = "unique code for users", example = "1")
    private int userCode;
}
