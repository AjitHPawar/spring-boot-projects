package com.spring.advice;

import com.spring.exception.RecordNotDeleteException;
import com.spring.exception.RecordNotFoundException;
import com.spring.exception.RecordNotSavedException;
import com.spring.exception.RecordNotUpdatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentException(MethodArgumentNotValidException ex) {
        Map<String, String> error = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(each -> error.put(each.getField(), each.getDefaultMessage()));
        return error;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public Map<String, String> recordIsNotFoundException(RecordNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("ErrorMessage", ex.getMessage());
        error.put("StatusCode", "" + HttpStatus.BAD_REQUEST);
        return error;
    }

    @ExceptionHandler(RecordNotSavedException.class)
    public Map<String, String> recordNotSavedException(RecordNotSavedException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("ErrorMessage", ex.getMessage());
        error.put("StatusCode", "" + HttpStatus.BAD_REQUEST);
        return error;
    }

    @ExceptionHandler(RecordNotUpdatedException.class)
    public Map<String, String> recordNotUpdatedException(RecordNotUpdatedException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("ErrorMessage", ex.getMessage());
        error.put("StatusCode", "" + HttpStatus.BAD_REQUEST);
        return error;
    }

    @ExceptionHandler(RecordNotDeleteException.class)
    public Map<String, String> recordNotDeleteException(RecordNotDeleteException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("ErrorMessage", "Failed please check..." + ex.getMessage());
        error.put("StatusCode", "" + HttpStatus.BAD_REQUEST);
        return error;
    }
}
