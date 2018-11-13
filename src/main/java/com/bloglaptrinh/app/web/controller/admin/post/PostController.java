package com.bloglaptrinh.app.web.controller.admin.post;


import com.bloglaptrinh.app.common.constant.Constants;
import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.model.CustomResponse;
import com.bloglaptrinh.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin_")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("post/list")
    public String list(){
        return "admin/post/list";
    }
    @GetMapping("post/new")
    public String newPost(){
        System.out.println("a");
        return "admin/post/create";
    }

    @PutMapping("post/create")
    public ResponseEntity<CustomResponse> createPost(@RequestBody Post post){
        CustomResponse customResponse = new CustomResponse();
        post = postService.add(post);
        customResponse.setResultCode(Constants.ResultCode.SUCCESS);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

}
