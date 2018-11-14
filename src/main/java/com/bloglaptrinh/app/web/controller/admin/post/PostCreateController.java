package com.bloglaptrinh.app.web.controller.admin.post;


import com.bloglaptrinh.app.common.constant.Constants;
import com.bloglaptrinh.app.model.CustomResponse;
import com.bloglaptrinh.app.service.PostService;
import com.bloglaptrinh.app.web.form.PostCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("admin_")
public class PostCreateController {

    @Autowired
    private PostService postService;

    @PostMapping("post/create")
    public ResponseEntity<CustomResponse> newPost(@RequestBody PostCreateForm postJson) throws IOException {
        CustomResponse customResponse = new CustomResponse();
        postService.add(postJson.convertToPost());
        customResponse.setResultCode(Constants.ResultCode.SUCCESS);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

}
