package com.anhtm.ordersfood.converter;

import com.anhtm.ordersfood.common.BaseConverter;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter implements BaseConverter<UserDto, User> {

    @Override
    public UserDto entityToDto (User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setPhone(user.getPhone());
        dto.setUsername(user.getUsername());

        dto.setActive(user.getActive());
        dto.setCreatedDate(user.getCreatedDate());
        dto.setUpdatedDate(user.getUpdatedDate());
        dto.setCreatedBy(user.getCreatedBy());
        dto.setUpdatedBy(user.getUpdatedBy());
        return dto;
    }

    @Override
    public User dtoToEntity(UserDto userDto) {
        User entity = new User();
        entity.setId(userDto.getId());
        entity.setName(userDto.getName());
        entity.setEmail(userDto.getEmail());
        entity.setAddress(userDto.getAddress());
        entity.setPhone(userDto.getPhone());
        entity.setPassword(userDto.getPassword());
        entity.setUsername(userDto.getUsername());

        entity.setActive(userDto.getActive());
        entity.setCreatedBy(userDto.getCreatedBy());
        entity.setUpdatedBy(userDto.getUpdatedBy());
        return entity;
    }
}
