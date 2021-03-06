package com.anhtm.ordersfood.dto;

import com.anhtm.ordersfood.common.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDto extends BaseDto {

  @Schema(defaultValue = "null")
  private Integer id;

  private String name;

  @Schema(defaultValue = "OderfoodApp@gmail.com")
  private String email;

  private String address;

  @Schema(defaultValue = "0123619063")
  private String phone;

  private String username;

  private String password;
}
