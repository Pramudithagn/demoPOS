package com.personal.pos.demoPOS.adviser;

import com.personal.pos.demoPOS.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundExceptions(ClassNotFoundException e) {
        return new ResponseEntity<>(
                new StandardResponse(
                        404, e.getMessage()+" issue detected!", e
                ), HttpStatus.NOT_FOUND
        );
    }
}
