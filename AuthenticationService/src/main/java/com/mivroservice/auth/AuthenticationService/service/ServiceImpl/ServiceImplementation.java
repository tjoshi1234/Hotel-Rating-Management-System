package com.mivroservice.auth.AuthenticationService.service.ServiceImpl;

import com.mivroservice.auth.AuthenticationService.JwtUtil.JwtService;
import com.mivroservice.auth.AuthenticationService.entity.UserCredential;
import com.mivroservice.auth.AuthenticationService.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImplementation implements Services {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Override
    public UserCredential SaveUser(UserCredential userCredential) {

        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        restTemplate.postForObject("http://USER-SERVICE/users",userCredential, ResponseEntity.class);
        return userCredential;
    }

    public String generateToken(String username){

        return jwtService.generateToken(username);
    }
}
