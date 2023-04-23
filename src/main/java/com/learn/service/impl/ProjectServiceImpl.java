package com.learn.service.impl;

import com.learn.dto.ProjectDTO;
import com.learn.entity.Project;
import com.learn.entity.User;
import com.learn.enums.Status;
import com.learn.mapper.ProjectMapper;
import com.learn.repository.ProjectRepository;
import com.learn.service.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return projectMapper.convertToDto(projectRepository.findByProjectCode(code));
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> list = projectRepository.findAll(Sort.by("projectCode"));


        return list.stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO dto) {
        dto.setProjectStatus(Status.OPEN);

        projectRepository.save(projectMapper.covertToEntity(dto));

    }

    @Override
    public void update(ProjectDTO dto) {

        //find current project
        Project project = projectRepository.findByProjectCode(dto.getProjectCode());
        //convert to entity
        Project convertedProject = projectMapper.covertToEntity(dto);
        //set id to the converted object
        convertedProject.setId(project.getId());
        //save the updated project in the db

        convertedProject.setProjectStatus(project.getProjectStatus());

        projectRepository.save(convertedProject);

    }

    @Override
    public void delete(String code) {
        Project project =  projectRepository.findByProjectCode(code);
        project.setIsDeleted(true);

        projectRepository.save(project);
    }

    @Override
    public void complete(String code) {

        Project project = projectRepository.findByProjectCode(code);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }

}
