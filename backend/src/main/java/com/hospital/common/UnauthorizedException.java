package com.hospital.common;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends AppException {
    public UnauthorizedException(String message) {
        super(message, "UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }
}
