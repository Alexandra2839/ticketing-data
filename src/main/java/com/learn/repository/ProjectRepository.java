package com.learn.repository;

import com.learn.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(String code);
}
