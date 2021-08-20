package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.dto.CategoriesDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/categories")
public interface CategoriesController {

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity<CategoriesDto> save(@RequestBody CategoriesDto dto);

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity<CategoriesDto> update(@RequestBody CategoriesDto t);

    @DeleteMapping(path = "/delete", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity<CategoriesDto> delete(Integer id);

    @DeleteMapping(path = "/delete-flush", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public abstract ResponseEntity<CategoriesDto> deleteAndFlush(Integer id);
}
