package com.portfoliobackend.application.handlers;

import com.portfoliobackend.application.dto.req.ProjectReqDto;
import com.portfoliobackend.application.dto.res.ProjectResDto;

import java.util.List;

public interface IProjectHandler {
    void createProject(ProjectReqDto project);
    List<ProjectResDto> getProjects(int userCode, int pageSize, int pageNumber);
    void updateProject(ProjectReqDto project, Long id);
    void deleteProject(Long id);
}
