package com.learn.service.impl;

import com.learn.dto.TaskDTO;
import com.learn.entity.Task;
import com.learn.entity.User;
import com.learn.enums.Status;
import com.learn.mapper.TaskMapper;
import com.learn.repository.TaskRepository;
import com.learn.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDTO> listAllTasks() {

        return taskRepository.findAll().stream().map(taskMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(TaskDTO dto) {

        dto.setTaskStatus(Status.OPEN);
        dto.setAssignedDate(LocalDate.now());

        taskRepository.save(taskMapper.covertToEntity(dto));

    }

    @Override
    public void update(TaskDTO dto) {

    }

    @Override
    public void delete(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {

            task.get().setIsDeleted(true);
            taskRepository.save(task.get());
        }



    }

    @Override
    public TaskDTO findById(Long id) {
        return null;
    }
}