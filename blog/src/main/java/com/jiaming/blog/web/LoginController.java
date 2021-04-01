package com.jiaming.blog.web;

import javax.servlet.http.HttpSession;

import com.jiaming.blog.po.User;
import com.jiaming.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class LoginController {
    
    @Autowired
    private UserService userService;

    @GetMapping()
    public String loginPage(){
        return "/admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userName, 
        @RequestParam String passWord, 
        HttpSession httpSession,
        RedirectAttributes redirectAttributes){

        User user = userService.checkUser(userName, DigestUtils.md5DigestAsHex(passWord.getBytes()));
        if (user != null){
            user.setPassWord(null); // Dont put password to session
            httpSession.setAttribute("user", user);
            return "/admin/index";
        }
        else{
            redirectAttributes.addFlashAttribute("message", "Username or Password Invilid"); // remind user
            return "redirect:/admin"; // Redirect Page
        }
        
    }

    @GetMapping("/logout")
    public String logout (HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/admin";

    }

}
