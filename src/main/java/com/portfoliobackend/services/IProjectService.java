package com.portfoliobackend.services;

import com.portfoliobackend.application.dto.res.ProjectResDto;
import com.portfoliobackend.domain.entity.ProjectEntity;

import java.util.List;

public interface IProjectService {
    void createProject(ProjectEntity project);
    List<ProjectResDto> getProjects(int userCode, int pageSize, int pageNumber);
    void updateProject(ProjectEntity project, Long id);
    void deleteProject(Long id);
}
