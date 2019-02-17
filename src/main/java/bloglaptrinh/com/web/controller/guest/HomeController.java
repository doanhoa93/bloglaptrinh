package bloglaptrinh.com.web.controller.guest;

import bloglaptrinh.com.domain.PaggingResult;
import bloglaptrinh.com.domain.Post;
import bloglaptrinh.com.domain.User;
import bloglaptrinh.com.model.PostSearchRequest;
import bloglaptrinh.com.service.post.PostService;
import bloglaptrinh.com.service.user.UserService;
import bloglaptrinh.com.web.support.AuthorizedUser;
import bloglaptrinh.com.web.support.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping({"/"})
    public String dashboard(@RequestParam(defaultValue = "") String keyword,
                            @PageableDefault(50) Pageable pageable,
                            Model model,
                            HttpServletRequest servletRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthorizedUser authorizedUser = null;
        if (authentication != null && authentication.getPrincipal() instanceof AuthorizedUser) {
            authorizedUser = (AuthorizedUser) authentication.getPrincipal();
        }
        Object o = authentication.getPrincipal();
        System.out.println(authentication.getPrincipal());
        PostSearchRequest request = new PostSearchRequest("vi").withKeyword(keyword);
        Page<Post> posts = postService.getPosts(request, pageable);
        model.addAttribute("keyword", keyword);
        model.addAttribute("listItem", posts.getContent());
        model.addAttribute("pageable", pageable);
        model.addAttribute("pagination", new Pagination<>(posts, servletRequest));
        return "guest/index";
    }

    @GetMapping("post/{code}")
    public String newPost(@PathVariable("code") String code, Model model, HttpServletRequest request){
        try {
            Post post = postService.getPostByCode(code);
            model.addAttribute("item",post);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "guest/post/detail";
    }

    @GetMapping("getuser")
    public String get(Model model, @RequestParam(required = false,defaultValue = "1") int pageNumber,
                      @RequestParam(required = false,defaultValue = "50") int pageSize){
        User users = userService.getByEmail("hoa9x3@gmail.com");
        model.addAttribute("users", users);

        return "admin/index";
    }

    @GetMapping("comments")
    public String comments(Model model, @RequestParam(required = false,defaultValue = "1") int pageNumber,
                           @RequestParam(required = false,defaultValue = "50") int pageSize){

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
