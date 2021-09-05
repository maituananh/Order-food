package com.anhtm.ordersfood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LogAppDto {
    @Schema(defaultValue = "anhtm")
    private String username;

    @Schema(defaultValue = "root")
    private String password;
}
