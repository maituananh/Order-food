package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    ResponseEntity<UserDto> save(@RequestBody UserDto dto);

    ResponseEntity<UserDto> update(UserDto t);

    ResponseEntity<UserDto> delete(Integer id);

    ResponseEntity<UserDto> deleteAndFlush(Integer id);
}
