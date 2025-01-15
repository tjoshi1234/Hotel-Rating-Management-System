package com.tapan.user.service.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tapan.user.service.entities.Hotel;
import com.tapan.user.service.entities.Rating;
import com.tapan.user.service.entities.User;
import com.tapan.user.service.exceptions.ResourceNotFoundException;
import com.tapan.user.service.externalservices.HotelService;
import com.tapan.user.service.repositories.UserRepository;
import com.tapan.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HotelService hotelService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public User saveUser(User user) {

        // generate unique userId in string format
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return this.userRepository.save(user);
    }


    public List<User> getAllUser() {
        List<User> allUsers = userRepository.findAll();

        for(User user : allUsers){
            user.setRatings(restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),ArrayList.class));
        }
        return allUsers;
    }


    public User getUser(String userId) throws ResourceNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException(userId));

        // calling RATING-SERVICE from this service for fetching rating of the above user from RATING SERVICE

//        ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/" + userId, ArrayList.class);

        JsonNode newratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId , JsonNode.class);

        ArrayList<Rating> ratingsOfUser = (ArrayList<Rating>) objectMapper.convertValue(newratingsOfUser, new TypeReference<List<Rating>>(){});

        for(Rating rating : ratingsOfUser){
            // calling HOTEL-SERVICE from this service for fetching hotel rated by the above user from HOTEL SERVICE (USING REST TEMPLATE)

//            ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
         //   rating.setHotel(hotel.getBody());

            // calling HOTEL-SERVICE from this service for fetching hotel rated by the above user from HOTEL SERVICE (USING FEIGN CLIENT)

            rating.setHotel(hotelService.getHotel(rating.getHotelId()));

        }
        user.setRatings(ratingsOfUser);
        return user;
    }
}
