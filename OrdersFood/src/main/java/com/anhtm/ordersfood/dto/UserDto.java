package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto extends BaseDto {

  private Integer id;

  private String name;

  private String email;

  private String address;

  private String phone;

  private Set<ProductDto> productSet;
}
