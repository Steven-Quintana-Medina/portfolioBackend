package com.portfoliobackend.services.impl;

import com.portfoliobackend.application.dto.res.ProjectResDto;
import com.portfoliobackend.application.mappers.IProjectMapper;
import com.portfoliobackend.domain.entity.ProjectEntity;
import com.portfoliobackend.infrastructure.repository.IProjectRepository;
import com.portfoliobackend.services.IProjectService;
import com.portfoliobackend.services.exceptions.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    IProjectRepository projectRepository;
    @Autowired
    IProjectMapper projectMapper;

    @Override
    public void createProject(ProjectEntity project) {
        projectRepository.save(project);
    }

    @Override
    public List<ProjectResDto> getProjects(int userCode, int pageSize, int pageNumber) {
        pageNumber -= 1;
        PageRequest pageable = PageRequest.of(pageNumber,pageSize);
        return projectMapper.toProjectResDto(projectRepository.findByUserCode(pageable,userCode));
    }

    @Override
    public void updateProject(ProjectEntity project, Long id) {
        ProjectEntity updateProject = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);;
        updateProject.setName(project.getName());
        updateProject.setDescription(project.getDescription());
        updateProject.setTechnologies(project.getTechnologies());
        updateProject.setImage(project.getImage());
        updateProject.setLink(project.getLink());
        projectRepository.save(updateProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
