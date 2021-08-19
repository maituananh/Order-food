package com.anhtm.ordersfood.repository;

import com.anhtm.ordersfood.common.BaseRepository;
import com.anhtm.ordersfood.entity.Categories;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends BaseRepository<Categories, Integer> {
}
