package com.anhtm.ordersfood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBodyDto {
    Object data;
    HttpStatus status;
    Integer code;
    String message;
    Date date;

    public ResponseBodyDto(Object data, HttpStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.code = status.value();
        this.date = new Date();
    }
}
