package com.techblog.web.controller.admin.post;


import com.techblog.common.constant.Constants;
import com.techblog.domain.Post;
import com.techblog.domain.Tag;
import com.techblog.model.CustomResponse;
import com.techblog.service.post.PostService;
import com.techblog.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin_")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    @GetMapping("post/list")
    public String list(){
        return "admin/post/list";
    }
    @GetMapping("post/new")
    public String newPost(Model model){
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags",tags);
        return "admin/post/create";
    }

    @PutMapping("post/create")
    public ResponseEntity<CustomResponse> createPost(@RequestBody Post post) throws IOException {
        CustomResponse customResponse = new CustomResponse();
        post = postService.add(post);
        customResponse.setResultCode(Constants.ResultCode.SUCCESS);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

}
