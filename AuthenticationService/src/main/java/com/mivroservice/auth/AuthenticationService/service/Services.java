package com.mivroservice.auth.AuthenticationService.service;

import com.mivroservice.auth.AuthenticationService.entity.UserCredential;

public interface Services {

    public UserCredential SaveUser(UserCredential userCredential);
    public String generateToken(String username);
}
