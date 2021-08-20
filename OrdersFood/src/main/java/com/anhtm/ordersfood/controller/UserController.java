package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/user")
public interface UserController {

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<UserDto> save(@RequestBody UserDto dto);

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<UserDto> update(@RequestBody UserDto t);

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<UserDto> delete(@PathVariable("id") Integer id);

    @DeleteMapping(path = "/delete-flush/{id}")
    ResponseEntity<UserDto> deleteAndFlush(@PathVariable("id") Integer id);
}
