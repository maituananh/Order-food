package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.common.BaseController;
import com.anhtm.ordersfood.dto.CartDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/cart")
public class CartController implements BaseController {

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CartDto> save(@RequestBody CartDto dto){return null;}

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CartDto> update(@RequestBody CartDto t){return null;}

    @DeleteMapping(path = "/delete")
    public ResponseEntity<CartDto> delete(Integer id){return null;}

    @DeleteMapping(path = "/delete-flush")
    public ResponseEntity<CartDto> deleteAndFlush(Integer id){return null;}
}
