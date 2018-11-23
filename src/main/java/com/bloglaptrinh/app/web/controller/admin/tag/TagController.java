package com.bloglaptrinh.app.web.controller.admin.tag;

import com.bloglaptrinh.app.common.constant.Constants;
import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.domain.Tag;
import com.bloglaptrinh.app.model.CustomResponse;
import com.bloglaptrinh.app.service.post.PostService;
import com.bloglaptrinh.app.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin_")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("tag/list")
    public String list(Model model){
        List<Tag> tags = tagService.findAll();
        model.addAttribute("listItem",tags);
        return "admin/tag/list";
    }

}
