package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.controller.UserController;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
    return userService.update(t);
  }

  @Override
  public ResponseEntity<UserDto> delete(Integer id) {
    return userService.delete(id);
  }

  @Override
  public ResponseEntity<UserDto> deleteAndFlush(Integer id) {
    return userService.deleteAndFlush(id);
  }
}
