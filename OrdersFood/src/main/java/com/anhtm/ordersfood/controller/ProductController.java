package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.common.BaseController;
import com.anhtm.ordersfood.dto.ProductDto;
import com.anhtm.ordersfood.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Controller", description = "REST Apis related to Product Entity.")
@RestController
@RequestMapping("api/product")
public class ProductController implements BaseController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity <Object> save (@RequestBody List<ProductDto> dtos) {
        return productService.save(dtos);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity <Object> delete (@PathVariable Integer id) {
        return null;
    }
}
