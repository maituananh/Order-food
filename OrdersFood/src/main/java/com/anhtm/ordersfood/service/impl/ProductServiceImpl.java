package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.converter.ProductConverter;
import com.anhtm.ordersfood.converter.UserConverter;
import com.anhtm.ordersfood.dto.ProductDto;
import com.anhtm.ordersfood.entity.Product;
import com.anhtm.ordersfood.repository.CategoriesRepository;
import com.anhtm.ordersfood.repository.ProductRepository;
import com.anhtm.ordersfood.repository.UserRepository;
import com.anhtm.ordersfood.service.ProductService;
import com.anhtm.ordersfood.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public ResponseEntity<Object> save(List<ProductDto> dtos) {
        if (dtos == null || dtos.size() == 0) {
            return ResponseUtils.response(null, "Object null", HttpStatus.BAD_REQUEST);
        }
        List<Product> products = new ArrayList <Product>(dtos.size());
        dtos.forEach(productDto -> {
            products.add(productConverter.dtoToEntity(productDto));
        });

        productRepository.saveAll(products);
        return ResponseUtils.response(dtos, "Completed", HttpStatus.OK);
    }
}
