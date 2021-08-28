package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto extends BaseDto {

  private Integer id;

  private String name;

  @Schema(defaultValue = "OderfoodApp@gmail.com")
  private String email;

  private String address;

  @Schema(defaultValue = "0123619063")
  private String phone;

  private String password;

  @Schema(nullable = true, defaultValue = "null")
  private Set<ProductDto> products;
}
