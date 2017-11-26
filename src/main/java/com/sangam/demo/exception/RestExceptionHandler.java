package com.sangam.demo.exception;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sangam.demo.entity.ErrorEntity;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ErrorEntity> handleEntityNotFound(
            EntityNotFoundException ex) {
        ErrorEntity error = new ErrorEntity(HttpStatus.NOT_FOUND, ex);
        return buildResponseEntity(error);
    }
 
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorEntity> invalidInput(ConstraintViolationException ex) {
    	ErrorEntity error = new ErrorEntity(HttpStatus.BAD_REQUEST, ex);
    	return buildResponseEntity(error);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        ErrorEntity errorMessage = new ErrorEntity(status);
        errorMessage.setFieldErrors(fieldErrors);
        return new ResponseEntity<Object>(errorMessage, headers, status);
    }

    
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        ErrorEntity errorMessage = new ErrorEntity(status, mostSpecificCause);
        return new ResponseEntity<Object>(errorMessage, headers, status);
    }
 
    private ResponseEntity<ErrorEntity> buildResponseEntity(ErrorEntity error) {
        return new ResponseEntity<ErrorEntity>(error, error.getStatus());
    }
}