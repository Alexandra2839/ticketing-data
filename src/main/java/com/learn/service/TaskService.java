package com.learn.service;

import com.learn.dto.TaskDTO;
import com.learn.dto.UserDTO;
import com.learn.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,Long>{

    List<TaskDTO> findTasksByManager(UserDTO manager);
    List<TaskDTO> findAllTasksByStatusIsNot(Status status);
    List<TaskDTO> findAllTasksByStatus(Status status);
    void updateStatus(TaskDTO task);

}
