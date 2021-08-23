package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.controller.UserController;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User Controller", description = "REST Apis related to User Entity.")
@RestController
public class UserControllerImpl extends UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity <Object> save (UserDto dto) {
        return userService.save(dto);
    }

    @Override
    public ResponseEntity <Object> update (UserDto t) {
        return userService.update(t);
    }

    @Override
    public ResponseEntity <Object> delete (Integer id) {
        return userService.delete(id);
    }

    @Override
    public ResponseEntity <Object> deleteAndFlush (Integer id) {
        return userService.deleteAndFlush(id);
    }
}
