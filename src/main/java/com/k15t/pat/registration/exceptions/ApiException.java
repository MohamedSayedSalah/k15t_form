package com.k15t.pat.registration.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiException extends RuntimeException {

    private HttpStatus statusCode;
    private LocalDateTime timestamp;
    private String messageCode;


    public ApiException(HttpStatus statusCode, String messageCode) {
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode;
        this.messageCode = messageCode;
    }
}
