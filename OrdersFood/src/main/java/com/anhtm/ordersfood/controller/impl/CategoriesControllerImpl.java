package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.controller.CategoriesController;
import com.anhtm.ordersfood.dto.CategoriesDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CategoriesControllerImpl implements CategoriesController {

    @Override
    public ResponseEntity<CategoriesDto> save(CategoriesDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<CategoriesDto> update(CategoriesDto t) {
        return null;
    }

    @Override
    public ResponseEntity<CategoriesDto> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<CategoriesDto> deleteAndFlush(Integer id) {
        return null;
    }
}
