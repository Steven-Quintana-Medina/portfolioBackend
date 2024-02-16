package com.portfoliobackend.application.handlers.impl;

import com.portfoliobackend.application.dto.req.ProjectReqDto;
import com.portfoliobackend.application.dto.res.ProjectResDto;
import com.portfoliobackend.application.handlers.IProjectHandler;
import com.portfoliobackend.application.mappers.IProjectMapper;
import com.portfoliobackend.services.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectHandler implements IProjectHandler {
    private final IProjectMapper projectMapper;
    private final IProjectService projectService;
    @Override
    public void createProject(ProjectReqDto projectReqDto) {
        projectService.createProject(projectMapper.toProjectEntity(projectReqDto));
    }

    @Override
    public List<ProjectResDto> getProjects(int userCode, int pageSize, int pageNumber) {
        return projectService.getProjects(userCode, pageSize, pageNumber);
    }

    @Override
    public void updateProject(ProjectReqDto project, Long id) {
        projectService.updateProject(projectMapper.toProjectEntity(project),id);
    }

    @Override
    public void deleteProject(Long id) {
        projectService.deleteProject(id);
    }
}
