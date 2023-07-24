package com.example.MJ_App_BE.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import javax.persistence.EntityNotFoundException;
//import javax.validation.ConstraintViolationException;
import static com.example.MJ_App_BE.exception.ErrorCode.DUPLICATE_RESOURCE;
import static com.example.MJ_App_BE.exception.ErrorCode.USER_NOT_FOUND;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ConstraintViolationException.class, DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponse> handleDataException() {
        log.error("handleDataException throw Exception : {}", DUPLICATE_RESOURCE);
        return ErrorResponse.toResponseEntity(DUPLICATE_RESOURCE);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleCustException() {
        log.error("handleDataException throw Exception : {}", USER_NOT_FOUND);
        return ErrorResponse.toResponseEntity(USER_NOT_FOUND);
    }

    @ExceptionHandler(value = {UserException.class})
    protected ResponseEntity<ErrorResponse> handleCustomException(UserException e){
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
