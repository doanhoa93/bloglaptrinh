package com.bloglaptrinh.app.web.controller.admin.post;


import com.bloglaptrinh.app.service.post.PostService;
import com.bloglaptrinh.app.web.controller.AbstractBaseController;
import com.bloglaptrinh.app.web.form.PostCreateForm;
import com.bloglaptrinh.app.web.support.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("admin_")
public class PostCreateController extends AbstractBaseController {

    @Autowired
    private PostService postService;

    @PostMapping("post/create")
    public ResponseEntity<Response> newPost(@RequestBody @Valid PostCreateForm postJson,
                                            BindingResult bindingResult, Model model) throws IOException {

        return responseUtil.successResponse(postService.add(postJson.convertToPost()));
    }

}
