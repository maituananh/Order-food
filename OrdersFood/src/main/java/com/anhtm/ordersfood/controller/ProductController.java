package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.dto.ProductDto;
import com.anhtm.ordersfood.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/product")
public interface ProductController {
    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity<ProductDto> save(@RequestBody List<ProductDto> dto);

    @DeleteMapping(path = "/delete/{id}")
    public abstract ResponseEntity<ProductDto> delete(@PathVariable("id") Integer id);
}
