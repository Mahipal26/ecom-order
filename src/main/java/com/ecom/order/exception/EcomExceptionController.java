package com.ecom.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcomExceptionController {

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<Object> exceptionCustomer(CustomerNotFoundException exception) {

        return new ResponseEntity<>("Customer Number not found: enter a valid customer number", HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<Object> exceptionOrder(OrderNotFoundException exception) {

        return new ResponseEntity<>("Order Number not found", HttpStatus.NOT_FOUND);

    }


}
