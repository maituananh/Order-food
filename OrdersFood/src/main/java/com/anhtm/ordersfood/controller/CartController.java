package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.dto.CartDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/cart")
public interface CartController {

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity<CartDto> save(@RequestBody CartDto dto);

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity<CartDto> update(@RequestBody CartDto t);

    @DeleteMapping(path = "/delete")
    public abstract ResponseEntity<CartDto> delete(Integer id);

    @DeleteMapping(path = "/delete-flush")
    public abstract ResponseEntity<CartDto> deleteAndFlush(Integer id);
}
