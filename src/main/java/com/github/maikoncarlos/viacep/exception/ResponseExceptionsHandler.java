package com.github.maikoncarlos.viacep.exception;


import com.github.maikoncarlos.viacep.services.exceptions.ZipcodeNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseExceptionsHandler {

    @ExceptionHandler(ZipcodeNullException.class)
    public ResponseEntity<StandardError> dataIntegrityViolation(ZipcodeNullException ex,
                                                                HttpServletRequest request){
        StandardError error = new StandardError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.toString(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
