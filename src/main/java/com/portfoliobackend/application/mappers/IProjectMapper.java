package com.portfoliobackend.application.mappers;

import com.portfoliobackend.application.dto.req.ProjectReqDto;
import com.portfoliobackend.application.dto.res.ProjectResDto;
import com.portfoliobackend.domain.entity.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IProjectMapper {
    @Mapping(target = "userCode", source = "userCode")
    ProjectEntity toProjectEntity(ProjectReqDto projectReqDto);
    List<ProjectResDto> toProjectResDto(Page<ProjectEntity> projectEntity);

}
