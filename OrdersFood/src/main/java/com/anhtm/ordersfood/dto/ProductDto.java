package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductDto extends BaseDto {

    @Schema(defaultValue = "null")
    private Integer id;

    private String name;

    private String description;

    @Schema(defaultValue = "40.000")
    private BigDecimal price;

    @Schema(defaultValue = "500.000")
    private BigDecimal cost;

    private Integer quantity;

//    private Integer mainPhotoId;
//    @Schema(defaultValue = "null", hidden = true)
//    private DataSourceDto mainPhoto;

    private Integer categoriesId;

    @Schema(defaultValue = "null", hidden = true)
    private CategoriesDto categories;

//  private Set<DataSourceDto> dataSourceProduct;

    @Schema(defaultValue = "null", hidden = true)
    private Set <CartProductDto> cartProducts;
}
