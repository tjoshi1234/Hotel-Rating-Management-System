package com.tapan.rating.service.services;

import com.tapan.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    // CREATE

    Rating create(Rating rating);

    // GET ALL RATINGS

    List<Rating> getAllRatings();

    // GET ALL BY userId

    List<Rating> getRatingsbyUserId(String userId);

    // GET ALL BY HOTEL

    List<Rating> getRatingsbyHotelId(String hotelId);
}
