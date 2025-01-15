package com.tapan.hotel.service.exceptions;

public class HotelNotFoundException extends Exception{

    private String hId;

    public HotelNotFoundException(String hId){
        super(String.format("Hotel with id %s not found",hId));
        this.hId = hId;
    }
}
