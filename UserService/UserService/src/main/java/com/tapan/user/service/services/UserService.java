package com.tapan.user.service.services;

import com.tapan.user.service.entities.User;
import com.tapan.user.service.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    // CREATE

    User saveUser(User user);

    // GET ALL USER

    List<User> getAllUser();

    // GET SINGLE USER OF GIVEN USERID

    User getUser(String userId) throws ResourceNotFoundException;
}
