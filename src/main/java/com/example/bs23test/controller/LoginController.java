package com.example.bs23test.controller;

import com.example.bs23test.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-success")
    public String loginSuccess() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.toString());
        return "login-success";
    }
}
