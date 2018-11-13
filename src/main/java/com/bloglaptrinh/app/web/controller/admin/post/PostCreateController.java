package com.bloglaptrinh.app.web.controller.admin.post;


import com.bloglaptrinh.app.common.constant.Constants;
import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.model.CustomResponse;
import com.bloglaptrinh.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin_/post")
public class PostCreateController {

    @Autowired
    private PostService postService;

    @PostMapping("create")
    public ResponseEntity<CustomResponse> newPost(@RequestBody Post post){
        CustomResponse customResponse = new CustomResponse();
        post = postService.add(post);
        customResponse.setResultCode(Constants.ResultCode.SUCCESS);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

}
