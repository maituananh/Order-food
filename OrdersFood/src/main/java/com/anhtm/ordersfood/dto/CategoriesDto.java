package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import lombok.Data;

import java.util.Set;

@Data
public class CategoriesDto extends BaseDto {

    private Integer id;

    private String name;

    private Set<ProductDto> products;
}
