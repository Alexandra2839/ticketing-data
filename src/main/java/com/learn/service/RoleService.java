package com.learn.service;

import com.learn.dto.RoleDTO;

import java.util.List;

public interface RoleService{
    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id);
}
