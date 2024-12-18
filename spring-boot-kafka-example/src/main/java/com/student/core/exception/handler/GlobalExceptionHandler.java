package com.student.core.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.student.core.exception.JsonPlaceHolderApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    record ErrorObject(String message, HttpStatus statusError, String body) {}

    @ExceptionHandler(JsonPlaceHolderApiException.class)
    public ResponseEntity<Object> handleJsonPlaceHolderApiException(JsonPlaceHolderApiException ex) {
        return new ResponseEntity<>(
          new ErrorObject(ex.getMessage(), ex.getStatusCode(), ex.getBody()),
          ex.getStatusCode());
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> handleJsonProcessingException(JsonProcessingException ex) {
        return new ResponseEntity<>(
          new ErrorObject("Impossible convert JSON to object", HttpStatus.EXPECTATION_FAILED, ex.getMessage()),
          HttpStatus.EXPECTATION_FAILED);
    }

}
