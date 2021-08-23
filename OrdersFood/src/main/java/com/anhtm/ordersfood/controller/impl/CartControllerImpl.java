package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.controller.CartController;
import com.anhtm.ordersfood.dto.CartDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CartControllerImpl implements CartController {

    @Override
    public ResponseEntity<CartDto> save(CartDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<CartDto> update(CartDto t) {
        return null;
    }

    @Override
    public ResponseEntity<CartDto> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<CartDto> deleteAndFlush(Integer id) {
        return null;
    }
}
