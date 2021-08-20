package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class CartDto extends BaseEntity<Serializable> {

    private Integer id;

    private Set<CartProductDto> cartProducts;

    private UserDto user;

    private Integer quantity;
}
