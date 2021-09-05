package com.anhtm.ordersfood.utils;

import com.anhtm.ordersfood.dto.ResponseBodyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    public static ResponseEntity<Object> response(Object data, String message, HttpStatus status) {
        return new ResponseEntity<Object>(new ResponseBodyDto(data, status,
                message), status);
    }
}
