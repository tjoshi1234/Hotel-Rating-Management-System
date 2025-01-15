package com.tapan.hotel.service.controllers;

import com.tapan.hotel.service.entities.Hotel;
import com.tapan.hotel.service.exceptions.HotelNotFoundException;
import com.tapan.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // create

    @PostMapping
    public ResponseEntity<Hotel> CreateHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(this.hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    // find all hotels

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return new ResponseEntity<>(this.hotelService.getAllHotels(),HttpStatus.OK);
    }

    // find single hotel

    @GetMapping("/{hId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hId) throws HotelNotFoundException {
        return new ResponseEntity<>(this.hotelService.getHotel(hId),HttpStatus.OK);
    }

}
