package com.anhtm.ordersfood.converter;

import com.anhtm.ordersfood.common.BaseConverter;
import com.anhtm.ordersfood.dto.CategoriesDto;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.entity.Categories;
import com.anhtm.ordersfood.entity.Product;
import com.anhtm.ordersfood.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoriesConverter implements BaseConverter <CategoriesDto, Categories> {

    @Autowired
    private ProductConverter productConverter;

    @Override
    public CategoriesDto entityToDto (Categories categories) {
        CategoriesDto dto = new CategoriesDto();
        dto.setId(categories.getId());
        dto.setName(categories.getName());
        dto.setProducts(null);

        dto.setActive(categories.getActive());
        dto.setCreatedDate(categories.getCreatedDate());
        dto.setUpdatedDate(categories.getUpdatedDate());
        dto.setCreatedBy(categories.getCreatedBy());
        dto.setUpdatedBy(categories.getUpdatedBy());
        return dto;
    }

    @Override
    public Categories dtoToEntity (CategoriesDto categoriesDto) {
        Categories entity = new Categories();
        entity.setId(categoriesDto.getId());
        entity.setName(categoriesDto.getName());

        if (categoriesDto.getProducts() != null) {
            Set<Product> products = new HashSet <>(categoriesDto.getProducts().size());

            categoriesDto.getProducts().forEach(productDto -> {
//                productDto.setCategories(categoriesDto);
                products.add(productConverter.dtoToEntity(productDto));
            });
            entity.setProducts(products);
        }

        entity.setActive(categoriesDto.getActive());
        entity.setCreatedBy(categoriesDto.getCreatedBy());
        entity.setUpdatedBy(categoriesDto.getUpdatedBy());
        return entity;
    }
}
