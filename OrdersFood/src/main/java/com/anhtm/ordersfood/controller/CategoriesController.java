package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.common.BaseController;
import com.anhtm.ordersfood.dto.CategoriesDto;
import com.anhtm.ordersfood.service.CategoriesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Categories Controller", description = "REST Apis related to Categories Entity.")
@RestController
@RequestMapping("api/categories")
public class CategoriesController implements BaseController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity <Object> save (@RequestBody CategoriesDto dto) {
        return categoriesService.save(dto);
    }

    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity <Object> update (@RequestBody CategoriesDto dto) {
        return categoriesService.update(dto);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity <Object> delete (Integer id) {
        return categoriesService.delete(id);
    }

    @DeleteMapping(path = "/delete-flush")
    public ResponseEntity <Object> deleteAndFlush (Integer id) {
        return categoriesService.deleteAndFlush(id);
    }
}
