package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseEntity;
import com.anhtm.ordersfood.entity.Cart;
import lombok.Data;

import java.io.Serializable;

@Data
public class CartProductDto extends BaseEntity<Serializable> {

    private Integer id;

    private Cart cart;

    private ProductDto product;

    private PayDto pay;
}
