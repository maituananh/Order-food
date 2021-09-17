package com.anhtm.ordersfood.common;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.CrossOrigin;

@SecurityRequirement(name = "Authorization")
@CrossOrigin(origins = "http://localhost:4200")
public interface BaseController {
}
