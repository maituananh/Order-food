package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto);

    public ResponseEntity<UserDto> update(UserDto t);

    public ResponseEntity<UserDto> delete(Integer id);
}
