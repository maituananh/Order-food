package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.controller.ProductController;
import com.anhtm.ordersfood.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController {

    @Override
    public ResponseEntity<ProductDto> save(List<ProductDto> dto) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> delete(Integer id) {
        return null;
    }
}
