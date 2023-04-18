package com.learn.service.impl;

import com.learn.dto.RoleDTO;
import com.learn.entity.Role;
import com.learn.mapper.RoleMapper;
import com.learn.repository.RoleRepository;
import com.learn.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    @Override
    public List<RoleDTO> listAllRoles() {
        //controller called me to bring roleDTOs so it can show in ui
        //need to make a call to db and get all roles from table
        //go to repository and find a service which gives me the roles from db
        //use di to call service from repo
        // need to convert role to roleDTO using ModelMapper

        return roleRepository.findAll().stream().map(roleMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}
