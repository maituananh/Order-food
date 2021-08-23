package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class CartProductDto extends BaseEntity<Serializable> {

    private Integer id;

    private CartDto cart;

    private Integer product_id;
//    private ProductDto product;

    private PayDto pay = null;
}
