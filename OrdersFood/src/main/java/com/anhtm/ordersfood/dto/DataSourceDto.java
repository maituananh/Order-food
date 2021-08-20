package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class DataSourceDto extends BaseEntity<Serializable> {

    private Integer id;

    private String name;

    private byte[] image;

    private ProductDto product;
}
