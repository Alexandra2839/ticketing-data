package com.learn.repository;

import com.learn.entity.Project;
import com.learn.entity.User;
import com.learn.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(String code);

    List<Project> findByAssignedManager(User manager);

    List<Project> findAllByProjectStatusIsNotAndAssignedManager(Status status, User assignedManager);
}
