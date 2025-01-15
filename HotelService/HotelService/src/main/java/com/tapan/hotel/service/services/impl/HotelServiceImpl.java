package com.tapan.hotel.service.services.impl;

import com.tapan.hotel.service.entities.Hotel;
import com.tapan.hotel.service.exceptions.HotelNotFoundException;
import com.tapan.hotel.service.repositories.HotelRepo;
import com.tapan.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    public Hotel createHotel(Hotel hotel) {
        String random_id = UUID.randomUUID().toString();
        hotel.setHId(random_id);
         hotelRepo.save(hotel);
         return hotel;
    }


    public List<Hotel> getAllHotels() {
        return this.hotelRepo.findAll();
    }


    public Hotel getHotel(String hId) throws HotelNotFoundException {
        return this.hotelRepo.findById(hId).orElseThrow(()->new HotelNotFoundException(hId));
    }
}
