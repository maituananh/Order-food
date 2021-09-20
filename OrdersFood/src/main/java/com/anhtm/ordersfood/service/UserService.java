package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.LogAppDto;
import com.anhtm.ordersfood.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity <Object> save(UserDto dto);

    ResponseEntity <Object> update(UserDto t);

    ResponseEntity <Object> delete(Integer id);

    ResponseEntity <Object> deleteAndFlush(Integer id);

    ResponseEntity <Object> findUser(LogAppDto dto);

    ResponseEntity <Object> findAllUser();

    ResponseEntity <Object> find(Integer id);
}
