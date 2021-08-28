package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductDto extends BaseDto {

  private Integer id;

  private String name;

  private String description;

  private BigDecimal price;

  private BigDecimal cost;

//  private Integer mainPhoto_id;
//  private DataSourceDto mainPhoto;

  private Integer categories_id;
//  private CategoriesDto categories;

  private Integer user_id;
//  private UserDto user;

  private boolean active;

  private Integer quantity;

//  private Set<DataSourceDto> dataSourceProduct;

  @Schema(defaultValue = "null", hidden = true)
  private Set<CartProductDto> cartProducts;
}
