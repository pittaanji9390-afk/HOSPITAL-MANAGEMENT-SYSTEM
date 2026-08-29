package com.hospital.common;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AppException {
    public BadRequestException(String message) {
        super(message, "BAD_REQUEST", HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(String message, String code) {
        super(message, code, HttpStatus.BAD_REQUEST);
    }
}
