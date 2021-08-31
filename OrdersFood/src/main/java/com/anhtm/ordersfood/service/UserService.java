package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    ResponseEntity <Object> save(UserDto dto);

    ResponseEntity <Object> update(UserDto t);

    ResponseEntity <Object> delete(Integer id);

    ResponseEntity <Object> deleteAndFlush(Integer id);

    UserDetails loadUserById(Long l);
}
