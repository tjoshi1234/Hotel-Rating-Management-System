package com.tapan.user.service.controllers;

import com.tapan.user.service.entities.User;
import com.tapan.user.service.exceptions.ResourceNotFoundException;
import com.tapan.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // create a user

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // get single user

    @GetMapping("/{userId}")
    //  @CircuitBreaker(name = "ratingHotelBreaker" , fallbackMethod = "ratingHotelFallBack")
    @Retry(name = "ratingHotelBreakerSingleUser",fallbackMethod = "ratingHotelFallBack")
    ResponseEntity<User> getSingleUser(@PathVariable String userId) throws ResourceNotFoundException {

        return new ResponseEntity<>(this.userService.getUser(userId),HttpStatus.OK);
    }

    // creating fallback method for the circuit breaker

    ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex){
       User u =  User.builder()
               .email("dummy@gmail.com")
               .about("This is a dummy user due to fallback because of service down")
               .name("Dummy User")
               .userId("dummyId").build();
        return new ResponseEntity<User>(u,HttpStatus.OK);
    }

    // get all users

//    int ratingCount = 1;

    @GetMapping("/allusers")
   // @CircuitBreaker(name = "ratingHotelFallBackAllUsers",fallbackMethod = "ratingHotelFallBackAllUsersMethod")
    @Retry(name = "ratingHotelFallBackAllUsersRetry",fallbackMethod = "ratingHotelFallBackAllUsersMethod")
    ResponseEntity<List<User>> getAllUsers(){

//        System.out.print("ratingCount : ");
//        System.out.println(ratingCount);
//        ratingCount++;
        return new ResponseEntity<>(this.userService.getAllUser(), HttpStatus.OK);
    }

    ResponseEntity<List<User>> ratingHotelFallBackAllUsersMethod(Exception ex){

      //  System.out.println("AAYA");
        User u =  User.builder()
                .email("dummyuserlist@gmail.com")
                .about("This is a dummy user list due to fallback because of service down")
                .name("Dummy User list")
                .userId("dummyIdList").build();
        List<User> dummyList = new ArrayList<>();
        dummyList.add(u);

        return new ResponseEntity<List<User>>(dummyList,HttpStatus.OK);
    }
}
