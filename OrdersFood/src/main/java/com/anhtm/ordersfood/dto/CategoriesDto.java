package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoriesDto extends BaseDto <Serializable> {

    @Schema(defaultValue = "null")
    private Integer id;

    private String name;

    private List <ProductDto> products;
}
