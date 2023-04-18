package com.learn.mapper;

import com.learn.dto.RoleDTO;
import com.learn.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Role covertToEntity(RoleDTO dto){
        return modelMapper.map(dto, Role.class);

    }

    public RoleDTO convertToDto(Role entity){
        return modelMapper.map(entity, RoleDTO.class);
    }


}
