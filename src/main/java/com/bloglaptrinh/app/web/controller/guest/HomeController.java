package com.bloglaptrinh.app.web.controller.guest;

import com.bloglaptrinh.app.domain.PaggingResult;
import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.domain.User;
import com.bloglaptrinh.app.model.PostSearchRequest;
import com.bloglaptrinh.app.service.UserService;
import com.bloglaptrinh.app.service.post.PostService;
import com.bloglaptrinh.app.web.support.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {



    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    /*@Autowired
    private IUserService service;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;*/

    @Inject
    private PaggingResult paggingResult;

    @GetMapping({"trang-chu","/"})
    public String dashboard(@RequestParam(defaultValue = "") String keyword,
                            @PageableDefault(50) Pageable pageable,
                            Model model,
                            HttpServletRequest servletRequest) {
        PostSearchRequest request = new PostSearchRequest("vi").withKeyword(keyword);
        Page<Post> posts = postService.getPosts(request, pageable);
        model.addAttribute("keyword", keyword);
        model.addAttribute("posts", posts);
        model.addAttribute("pageable", pageable);
        model.addAttribute("pagination", new Pagination<>(posts, servletRequest));
        return "guest/index";
    }

    @GetMapping("getuser")
    public String get(Model model, @RequestParam(required = false,defaultValue = "1") int pageNumber,
                      @RequestParam(required = false,defaultValue = "50") int pageSize){
        User users = userService.getByEmail("hoa9x3@gmail.com");
        model.addAttribute("users", users);

        return "admin/index";
    }

    @GetMapping("/lien-he")
    public String contact(Model model){
        return "guest/contact";
    }

    @GetMapping("/gioi-thieu")
    public String about(Model model){
        return "guest/about";
    }

    @GetMapping("chat-box")
    public String chatbox(Model model){
        return "index";
    }

    @GetMapping("chat")
    public String chat(Model model){
        return "chat";
    }
}
