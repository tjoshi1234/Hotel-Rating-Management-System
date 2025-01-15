package com.tapan.rating.service.services.serviceImpl;

import com.tapan.rating.service.entities.Rating;
import com.tapan.rating.service.repositories.RatingRepo;
import com.tapan.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
   private RatingRepo ratingRepo;


    public Rating create(Rating rating) {
        String randomid = UUID.randomUUID().toString();
        rating.setRatingId(randomid);
        return this.ratingRepo.save(rating);
    }


    public List<Rating> getAllRatings() {
        return this.ratingRepo.findAll();
    }


    public List<Rating> getRatingsbyUserId(String userId) {
        return this.ratingRepo.findByUserId(userId);
    }


    public List<Rating> getRatingsbyHotelId(String hotelId) {
//        System.out.println("hotel id in getRatingsbyHotelId method : " + hotelId);
//        System.out.println("SEX");
        return this.ratingRepo.findByHotelId(hotelId);
    }
}
