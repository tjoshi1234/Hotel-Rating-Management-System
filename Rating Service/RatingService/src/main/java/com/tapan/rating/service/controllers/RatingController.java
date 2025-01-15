package com.tapan.rating.service.controllers;

import com.tapan.rating.service.entities.Rating;
import com.tapan.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // create rating

    @PostMapping
    ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return new ResponseEntity<>(this.ratingService.create(rating), HttpStatus.CREATED);
    }

    // get all ratings

    @GetMapping
    ResponseEntity<List<Rating>> getAllRatings(){
        return new ResponseEntity<>(this.ratingService.getAllRatings(), HttpStatus.OK);
    }

    // get by user id

    @GetMapping("/users/{userId}")
    ResponseEntity<List<Rating>> getRatingbyUser(@PathVariable String userId){
        return new ResponseEntity<>(this.ratingService.getRatingsbyUserId(userId),HttpStatus.OK);
    }

    // get by hotel id

    @GetMapping("/hotels/{hotelId}")
    ResponseEntity<List<Rating>> getRatingbyHotel(@PathVariable String hotelId){
     //   System.out.println("reached getRatingbyHotel method in the controller with hotel id as  " + hotelId);
        return new ResponseEntity<>(this.ratingService.getRatingsbyHotelId(hotelId),HttpStatus.OK);
    }
}
