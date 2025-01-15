package com.tapan.user.service.exceptions;

public class ResourceNotFoundException extends Exception{

    private String userId;

    public ResourceNotFoundException(String userId) {
        super(String.format("User with %s not found",userId));
        this.userId = userId;
    }
}
