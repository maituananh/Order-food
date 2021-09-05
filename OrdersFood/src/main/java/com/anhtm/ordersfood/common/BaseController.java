package com.anhtm.ordersfood.common;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "Authorization")
public interface BaseController {
}
