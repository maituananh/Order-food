package com.anhtm.ordersfood.converter;

import com.anhtm.ordersfood.common.BaseConverter;
import com.anhtm.ordersfood.dto.ProductDto;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.entity.Product;
import com.anhtm.ordersfood.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductConverter implements BaseConverter<ProductDto, Product> {

    @Override
    public ProductDto entityToDto (Product entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCost(entity.getCost());
        dto.setDescription(entity.getDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setActive(entity.getActive());
        dto.setCategories_id(entity.getCategories().getId());
        Set set = new HashSet();
        dto.setCartProducts();
        return dto;
    }

    @Override
    public Product dtoToEntity(ProductDto dto) {
        Product entity = new Product();
        entity.setId(userDto.getId());
        entity.setName(userDto.getName());
        entity.setEmail(userDto.getEmail());
        entity.setAddress(userDto.getAddress());
        entity.setPhone(userDto.getPhone());
        entity.setPassword(userDto.getPassword());
        entity.setProducts(null);
        return entity;
    }
}
