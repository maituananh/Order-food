package com.anhtm.ordersfood.converter;

import com.anhtm.ordersfood.common.BaseConverter;
import com.anhtm.ordersfood.dto.ProductDto;
import com.anhtm.ordersfood.entity.Product;
import com.anhtm.ordersfood.repository.CategoriesRepository;
import com.anhtm.ordersfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter implements BaseConverter<ProductDto, Product> {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProductDto entityToDto (Product entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCost(entity.getCost());
        dto.setMainPhotoId(null);
        dto.setDescription(entity.getDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setCategoriesId(entity.getCategories().getId());
        dto.setCartProducts(null);

        dto.setActive(entity.getActive());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
//        dto.setCreatedBy(entity.getCreatedBy());
//        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    @Override
    public Product dtoToEntity(ProductDto dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        //mainPhoto
        entity.setCost(dto.getCost());
        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity());
        entity.setCategories(categoriesRepository.findById(dto.getCategoriesId()).get());
        entity.setActive(dto.getActive());
//        entity.setCreatedBy(userRepository. dto.getCreatedBy());
//        entity.setUpdatedBy(dto.getUpdatedBy());
//        entity.setCartProducts();
        return entity;
    }
}
