package com.github.maikoncarlos.viacep.services.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZipcodeNullException extends RuntimeException {
    public ZipcodeNullException(String message) {
        super(message);
    }
}
