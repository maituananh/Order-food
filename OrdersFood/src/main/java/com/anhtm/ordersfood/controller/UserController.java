package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Controller", description = "REST Apis related to User Entity.")
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity <Object> save (@RequestBody UserDto dto) {
        return userService.save(dto);
    }

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity <Object> update (@RequestBody UserDto t) {
        return userService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity <Object> delete (@PathVariable("id") Integer id) {
        return userService.delete(id);
    }

    @DeleteMapping(path = "/delete-flush/{id}")
    public ResponseEntity <Object> deleteAndFlush (@PathVariable("id") Integer id) {
        return userService.deleteAndFlush(id);
    }
}
