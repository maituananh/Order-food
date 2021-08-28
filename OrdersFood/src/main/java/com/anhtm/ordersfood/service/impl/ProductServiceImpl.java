package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.dto.ProductDto;
import com.anhtm.ordersfood.repository.ProductRepository;
import com.anhtm.ordersfood.service.ProductService;
import com.anhtm.ordersfood.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Object> save(ProductDto dto) {
        if (dto == null) {
            return ResponseUtils.response(null, "Object null", HttpStatus.BAD_REQUEST);
        }

        productRepository.save(dto);

        return null;
    }
}
