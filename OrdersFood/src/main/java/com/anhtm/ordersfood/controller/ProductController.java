package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.dto.ProductDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User Product", description = "REST Apis related to Product Entity.")
@RestController
@RequestMapping("api/user")
public class ProductController {

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductDto> save(List<ProductDto> dto) {
        return null;
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ProductDto> delete(Integer id) {
        return null;
    }
}
