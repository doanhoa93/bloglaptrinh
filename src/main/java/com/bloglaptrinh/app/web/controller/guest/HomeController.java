package com.bloglaptrinh.app.web.controller.guest;

import com.bloglaptrinh.app.common.entity.PaggingResult;
import com.bloglaptrinh.app.model.User;
import com.bloglaptrinh.app.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {



    @Autowired
    private UserService userService;

    /*@Autowired
    private IUserService service;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;*/

    @Inject
    private PaggingResult paggingResult;

    @GetMapping({"trang-chu","/"})
    public String dashboard(Model model, HttpServletRequest request){
        try {
            //List<Category> categoryList = categoryService.getAll();
            String page = request.getParameter("page");
            if(StringUtils.isBlank(page)){
                page = "1";
            }
            if(!StringUtils.isNumeric(page)){
                page = "1";
            }
            List<String> nameCategory = new ArrayList<>();
            nameCategory.add("C/C++");
            nameCategory.add("Java");
            nameCategory.add("C#");
            nameCategory.add("PHP");
            nameCategory.add("Python");
            nameCategory.add("Ngôn ngữ khác");
            model.addAttribute("listItem",paggingResult.getItemList());
            model.addAttribute("listCategory",nameCategory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "guest/index";
    }

    @GetMapping("getuser")
    public String get(Model model, @RequestParam(required = false,defaultValue = "1") int pageNumber,
                      @RequestParam(required = false,defaultValue = "50") int pageSize){
        Page<User> users = userService.getUsers(pageNumber,pageSize);
        model.addAttribute("users", users.getContent());

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
