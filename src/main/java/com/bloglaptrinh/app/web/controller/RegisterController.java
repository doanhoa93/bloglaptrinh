package com.bloglaptrinh.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("register")
public class RegisterController {


    @RequestMapping(value = "register", method = {RequestMethod.GET, RequestMethod.POST})
    public String regiter(){

        return "";
    }
}
