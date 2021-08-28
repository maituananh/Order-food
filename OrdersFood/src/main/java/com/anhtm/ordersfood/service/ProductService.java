package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.ProductDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<Object> save(ProductDto dto);
}
