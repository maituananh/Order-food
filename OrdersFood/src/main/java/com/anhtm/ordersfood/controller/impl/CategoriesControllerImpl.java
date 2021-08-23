package com.anhtm.ordersfood.controller.impl;

import com.anhtm.ordersfood.controller.CategoriesController;
import com.anhtm.ordersfood.dto.CategoriesDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Categories controller.
 */
@RestController
@Slf4j
public class CategoriesControllerImpl implements CategoriesController {

    /**
     * Save response entity.
     *
     * @param dto the dto
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity<CategoriesDto> save(CategoriesDto dto) {
        return null;
    }

    /**
     * Update response entity.
     *
     * @param t the t
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity<CategoriesDto> update(CategoriesDto t) {
        return null;
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity<CategoriesDto> delete(Integer id) {
        return null;
    }

    /**
     * Delete and flush response entity.
     *
     * @param id the id
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity<CategoriesDto> deleteAndFlush(Integer id) {
        return null;
    }
}
