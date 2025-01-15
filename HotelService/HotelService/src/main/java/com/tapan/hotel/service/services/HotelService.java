package com.tapan.hotel.service.services;

import com.tapan.hotel.service.entities.Hotel;
import com.tapan.hotel.service.exceptions.HotelNotFoundException;

import java.util.List;

public interface HotelService {

    // CREATE

    public Hotel createHotel(Hotel hotel);

    // GET ALL

    public List<Hotel> getAllHotels();

    // GET SINGLE

    public Hotel getHotel(String hId) throws HotelNotFoundException;
}
