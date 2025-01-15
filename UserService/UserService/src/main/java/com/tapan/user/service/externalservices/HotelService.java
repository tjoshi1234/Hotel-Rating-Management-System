package com.tapan.user.service.externalservices;

import com.tapan.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {


    // METHODS OF THIS INTERFACE IS NOT EXPLICITLY NEEDED TO BE IMPLEMENTED BUT THE SPRING WILL PROVIDE A RUNTIME IMPLEMENTATION
    // FOR IT USING ALL THE INFORMATIONS OF THIS INTERFACE AND METHOD

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
