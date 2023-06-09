package com.learn.service.impl;

import com.learn.dto.RoleDTO;
import com.learn.mapper.MapperUtil;
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
    private final MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<RoleDTO> listAllRoles() {
        //controller called me to bring roleDTOs so it can show in ui
        //need to make a call to db and get all roles from table
        //go to repository and find a service which gives me the roles from db
        //use di to call service from repo
        // need to convert role to roleDTO using ModelMapper

      //  return roleRepository.findAll().stream().map(roleMapper::convertToDto).collect(Collectors.toList());
       // return roleRepository.findAll().stream().map(role -> mapperUtil.convert(role, new RoleDTO())).collect(Collectors.toList());
        return roleRepository.findAll().stream().map(role -> mapperUtil.convert(role, RoleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {


        return roleMapper.convertToDto(roleRepository.findById(id).get());
    }
}
