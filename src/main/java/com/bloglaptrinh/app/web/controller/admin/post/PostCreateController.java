package com.bloglaptrinh.app.web.controller.admin.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin_")
public class PostCreateController {

    @PostMapping("post-create")
    public String newPost(@RequestParam String body, @RequestParam String title){

        return "admin/post/new";
    }

}
