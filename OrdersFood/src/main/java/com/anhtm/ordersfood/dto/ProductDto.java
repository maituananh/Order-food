package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import lombok.Data;

@Data
public class ProductDto extends BaseDto {
  private Integer id;

  private String name;

  private String description;

  private Integer price;

  private Integer mainPhoto;

  private CategoriesDto categories;

  private UserDto user;

  private boolean active;
}
