package com.tapan.hotel.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/staffs")
public class StaffController {


    @GetMapping
    public ResponseEntity<List<String>> getAllStaffs(){

        List<String> staffList = Arrays.asList("Akshank","Bajpai");
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }
}
