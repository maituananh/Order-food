package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.anhtm.ordersfood.controller.UserController;
import com.anhtm.ordersfood.dto.UserDto;

@RestController
public class UserControllerImpl implements UserController {

  @Autowired
  private UserService userService;

  @Override
  public ResponseEntity<UserDto> save(UserDto dto) {
    return userService.save(dto);
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
