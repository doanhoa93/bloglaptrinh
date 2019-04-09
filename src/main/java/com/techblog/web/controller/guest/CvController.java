package com.techblog.web.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CvController {

    @GetMapping({"/create-cv"})
    public String get(){
        return "guest/cv/cv-doan-quang-hoa";
    }

    @GetMapping({"/cv-preview"})
    public String preview(){
        return "guest/cv/green-blur";
    }
}
