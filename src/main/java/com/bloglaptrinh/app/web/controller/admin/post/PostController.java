package com.bloglaptrinh.app.web.controller.admin.post;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin_")
public class PostController {


    @GetMapping("post/list")
    public String list(){
        return "admin/post/list";
    }
    @GetMapping("post-new")
    public String newPost(){
        return "admin/post/new";
    }

}
