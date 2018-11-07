package com.bloglaptrinh.app.controller;

import com.bloglaptrinh.app.model.User;
import com.bloglaptrinh.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping
public class HomeController {

    final static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    /*@Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
*/
    @RequestMapping(value = "home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<String>("hahaha", HttpStatus.OK);
    }

    @GetMapping("getuser")
    public String get(Model model, @RequestParam(required = false,defaultValue = "1") int pageNumber,
                      @RequestParam(required = false,defaultValue = "50") int pageSize){
        Page<User> users = userService.getUsers(pageNumber,pageSize);
        model.addAttribute("users", users.getContent());

        return "admin/user";
    }

    @PostMapping("user/add")
    public String add(@RequestBody @Valid User user){
        try {
            User result = userService.add(user);
            if(result != null && result.getId() > 0){
                return result.getEmail();
            }else{
                return null;
            }
        }catch (Exception e){
            logger.error("Có lỗi xảy ra tại hàm thêm mới người dùng :",e);
            return null;
        }
    }


}
