package com.tapan.hotel.service.exceptions;

import com.tapan.hotel.service.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ApiResponse> handleHotelNotFoundException(HotelNotFoundException ex){
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build(),HttpStatus.NOT_FOUND);
    }
}
