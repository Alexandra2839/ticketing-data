package com.learn.converter;

import com.learn.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {
    @Override
    public UserDTO convert(String source) {
        return null;
    }

//    UserService userService;
//
//    public UserDtoConverter(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDTO convert(String source) {
//
//        if (source == null || source.equals("")) {
//            return null;
//        }
//
//        return userService.findById(source);
//
//    }

}
