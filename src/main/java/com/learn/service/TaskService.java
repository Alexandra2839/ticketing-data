package com.learn.service;

import com.learn.dto.TaskDTO;
import com.learn.entity.Task;

import java.util.List;

public interface TaskService {

    List<TaskDTO> listAllTasks();
    void save(TaskDTO dto);
    void update (TaskDTO dto);
    void delete (Long id);
    TaskDTO findById(Long id);





}