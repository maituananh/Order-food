package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto extends BaseDto {

  private Integer id;

  private String name;

  private String email;

  private String address;

  private String phone;

  private String password;

  @Schema(nullable = true, defaultValue = "null")
  private Set<ProductDto> products;
}
