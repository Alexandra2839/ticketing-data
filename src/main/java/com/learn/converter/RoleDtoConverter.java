package com.learn.converter;

import com.learn.dto.RoleDTO;
import com.learn.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConverter implements Converter<String, RoleDTO> {
    @Override
    public RoleDTO convert(String source) {
        return null;
    }

    RoleService roleService;
//
//    public RoleDtoConverter(RoleService roleService) {
//        this.roleService = roleService;
//    }
//
//    @Override
//    public RoleDTO convert(String source) {
//
//        if (source == null || source.equals("")) {  //  Select  -> ""
//            return null;
//        }
//
//        return roleService.findById(Long.parseLong(source));
//
//    }

}
