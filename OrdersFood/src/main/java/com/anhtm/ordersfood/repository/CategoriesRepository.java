package com.anhtm.ordersfood.repository;

import com.anhtm.ordersfood.common.BaseRepository;
import com.anhtm.ordersfood.entity.Categories;
import org.springframework.stereotype.Repository;

/**
 * The interface Categories repository.
 */
@Repository
public interface CategoriesRepository extends BaseRepository<Categories, Integer> {
}
