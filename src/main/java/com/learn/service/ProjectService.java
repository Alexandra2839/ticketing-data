package com.learn.service;

import com.learn.dto.ProjectDTO;
import com.learn.dto.UserDTO;

import java.util.List;

public interface  ProjectService extends CrudService<ProjectDTO,String>{

    void complete(ProjectDTO project);
    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);

}
