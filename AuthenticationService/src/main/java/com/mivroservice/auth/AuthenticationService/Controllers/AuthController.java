package com.mivroservice.auth.AuthenticationService.Controllers;

import com.mivroservice.auth.AuthenticationService.entity.UserCredential;
import com.mivroservice.auth.AuthenticationService.service.ServiceImpl.ServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ServiceImplementation serviceImplementation;

    @PostMapping("/authuser")
    public ResponseEntity<UserCredential> RegisterUser(@RequestBody UserCredential user){
                return new ResponseEntity<>(serviceImplementation.SaveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/token")
    public String getToken(@RequestBody UserCredential userCredential){
        return serviceImplementation.generateToken(userCredential.getName());
    }
}
