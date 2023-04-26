package com.learn.mapper;


import com.learn.dto.TaskDTO;

import com.learn.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Task covertToEntity(TaskDTO dto){
        return modelMapper.map(dto, Task.class);

    }

    public TaskDTO convertToDto(Task entity){
        return modelMapper.map(entity, TaskDTO.class);
    }
}
