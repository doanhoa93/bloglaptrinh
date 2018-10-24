package com.bloglaptrinh.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping(value = "home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<String>("hahaha", HttpStatus.OK);
    }
}
