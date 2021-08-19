package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.controller.CategoriesController;
import com.anhtm.ordersfood.dto.CategoriesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesControllerImpl extends CategoriesController {

    @Override
    public ResponseEntity<CategoriesDto> update(CategoriesDto t) {
        return null;
    }

    @Override
    public ResponseEntity<CategoriesDto> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<CategoriesDto> save() {
        return null;
    }
}
