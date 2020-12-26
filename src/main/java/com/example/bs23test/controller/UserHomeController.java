package com.example.bs23test.controller;

import com.example.bs23test.dto.UserDto;
import com.example.bs23test.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserHomeController {
    @GetMapping("/home")
    public String getHome(Model m){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        m.addAttribute("userDto", userDto);
        return "user/home";
    }
}
