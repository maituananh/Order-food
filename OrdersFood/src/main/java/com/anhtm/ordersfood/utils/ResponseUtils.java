package com.anhtm.ordersfood.utils;

import com.anhtm.ordersfood.dto.ResponseHeaderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    public static ResponseEntity<Object> response(Object data, String message, HttpStatus status) {
        return new ResponseEntity(new ResponseHeaderDto(data, status,
                message), status);
    }
}
