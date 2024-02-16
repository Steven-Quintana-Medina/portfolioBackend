package com.portfoliobackend.application.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProjectResDto {
    private Long id;
    private String name;
    private String description;
    private String technologies;
    private String image;
    private String link;
}
