package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.entity.User;
import com.anhtm.ordersfood.repository.UserRepository;
import com.anhtm.ordersfood.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<UserDto> save(UserDto dto) {
        User user = modelMapper.map(dto, User.class);
        userRepository.save(user);
        return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto t) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> delete(Integer id) {
        return null;
    }
}
