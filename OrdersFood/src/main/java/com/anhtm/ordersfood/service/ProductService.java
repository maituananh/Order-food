package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Object> save(List<ProductDto> dtos);

    ResponseEntity<Object> update(ProductDto productDto);

    ResponseEntity<Object> delete(Integer id);

    ResponseEntity<Object> deleteAndFlush(Integer id);

    ResponseEntity<Object> getAll();
}
