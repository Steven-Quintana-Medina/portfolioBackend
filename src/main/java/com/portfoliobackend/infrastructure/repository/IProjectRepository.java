package com.portfoliobackend.infrastructure.repository;

import com.portfoliobackend.domain.entity.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProjectRepository extends JpaRepository<ProjectEntity, Long> {
    @Query("SELECT p FROM ProjectEntity p WHERE p.userCode = :userCode")
    Page<ProjectEntity> findByUserCode(Pageable pageable, @Param("userCode") int userCode);
}
