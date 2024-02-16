package com.portfoliobackend.application.mappers;

import com.portfoliobackend.application.dto.req.ProjectReqDto;
import com.portfoliobackend.application.dto.res.ProjectResDto;
import com.portfoliobackend.domain.entity.ProjectEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-18T09:36:06-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class IProjectMapperImpl implements IProjectMapper {

    @Override
    public ProjectEntity toProjectEntity(ProjectReqDto projectReqDto) {
        if ( projectReqDto == null ) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setUserCode( projectReqDto.getUserCode() );
        projectEntity.setName( projectReqDto.getName() );
        projectEntity.setDescription( projectReqDto.getDescription() );
        projectEntity.setTechnologies( projectReqDto.getTechnologies() );
        projectEntity.setImage( projectReqDto.getImage() );
        projectEntity.setLink( projectReqDto.getLink() );

        return projectEntity;
    }

    @Override
    public List<ProjectResDto> toProjectResDto(Page<ProjectEntity> projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        List<ProjectResDto> list = new ArrayList<ProjectResDto>();
        for ( ProjectEntity projectEntity1 : projectEntity ) {
            list.add( projectEntityToProjectResDto( projectEntity1 ) );
        }

        return list;
    }

    protected ProjectResDto projectEntityToProjectResDto(ProjectEntity projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        String technologies = null;
        String image = null;
        String link = null;

        id = projectEntity.getId();
        name = projectEntity.getName();
        description = projectEntity.getDescription();
        technologies = projectEntity.getTechnologies();
        image = projectEntity.getImage();
        link = projectEntity.getLink();

        ProjectResDto projectResDto = new ProjectResDto( id, name, description, technologies, image, link );

        return projectResDto;
    }
}
