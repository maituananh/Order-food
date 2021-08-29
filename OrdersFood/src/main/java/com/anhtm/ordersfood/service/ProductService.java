package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Object> save(List<ProductDto> dtos);
}
