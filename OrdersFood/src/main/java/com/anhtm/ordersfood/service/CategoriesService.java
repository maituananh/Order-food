package com.anhtm.ordersfood.service;

import com.anhtm.ordersfood.dto.CategoriesDto;
import org.springframework.http.ResponseEntity;

public interface CategoriesService {

    ResponseEntity <Object> save(CategoriesDto dto);

    ResponseEntity <Object> update(CategoriesDto categoriesDto);

    ResponseEntity <Object> delete(Integer id);

    ResponseEntity <Object> deleteAndFlush(Integer id);
}
