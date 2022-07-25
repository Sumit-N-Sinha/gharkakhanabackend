package com.Gharkakhana.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CentralExceptionHandler {
    @ExceptionHandler(FoodItemNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(FoodItemNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String>methordArgumentNotValdException(MethodArgumentNotValidException e){
        String message=e.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.joining(","));
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> customerExceptionHandler(CustomerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(VendorNotFoundException.class)
    public ResponseEntity<String> vendorExceptionHandler(VendorNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler({OrderNotFoundException.class})
    public ResponseEntity<String> orderExceptionHandler(OrderNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }
}
