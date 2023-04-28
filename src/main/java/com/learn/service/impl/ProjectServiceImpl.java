package com.learn.service.impl;

import com.learn.dto.ProjectDTO;
import com.learn.dto.UserDTO;
import com.learn.entity.Project;
import com.learn.entity.User;
import com.learn.enums.Status;
import com.learn.mapper.ProjectMapper;
import com.learn.mapper.UserMapper;
import com.learn.repository.ProjectRepository;
import com.learn.service.ProjectService;
import com.learn.service.TaskService;
import com.learn.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    private final UserService userService;
    private final UserMapper userMapper;

    private final TaskService taskService;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, UserService userService, UserMapper userMapper, TaskService taskService) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.userService = userService;
        this.userMapper = userMapper;
        this.taskService = taskService;
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

        project.setProjectCode(project.getProjectCode() + "-" + project.getId()); // resetting project code, so we can create a project with the original code

        projectRepository.save(project);

        taskService.deleteByProject(projectMapper.convertToDto(project));
    }

    @Override
    public void complete(String code) {

        Project project = projectRepository.findByProjectCode(code);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);

        taskService.completeByProject(projectMapper.convertToDto(project));


    }

    @Override
    public List<ProjectDTO> listAllProjectDetails() {

        UserDTO currentUserDTO = userService.findByUserName("harold@manager.com");
        User user = userMapper.covertToEntity(currentUserDTO);

        List<Project> list = projectRepository.findByAssignedManager(user);

         return list.stream().map(project -> {

             ProjectDTO obj = projectMapper.convertToDto(project);

             obj.setUnfinishedTaskCounts(taskService.totalNonCompletedTask(project.getProjectCode()));
             obj.setCompleteTaskCounts(taskService.totalCompletedTask(project.getProjectCode()));
             return obj;

                 }
         ).collect(Collectors.toList());

    }

}
