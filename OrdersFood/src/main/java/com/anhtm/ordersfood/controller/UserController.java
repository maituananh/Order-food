package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.common.BaseController;
import com.anhtm.ordersfood.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/user")
public abstract class UserController implements BaseController {

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity <Object> save (@RequestBody UserDto dto);

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity <Object> update(@RequestBody UserDto t);

    @DeleteMapping(path = "/delete/{id}")
    public abstract ResponseEntity <Object> delete(@PathVariable("id") Integer id);

    @DeleteMapping(path = "/delete-flush/{id}")
    public abstract ResponseEntity <Object> deleteAndFlush(@PathVariable("id") Integer id);

    @Override
    public ResponseEntity <?> search() {
        return null;
    }
}
