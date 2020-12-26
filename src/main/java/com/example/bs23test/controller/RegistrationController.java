package com.example.bs23test.controller;

import com.example.bs23test.Repository.RoleRepository;
import com.example.bs23test.dto.UserDto;
import com.example.bs23test.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService regService;

    @GetMapping("/")
    public String add(Model m){
        m.addAttribute("userReg", new UserDto());
        return "reg";
    }


    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("userReg") UserDto userDto){
        regService.saveUser(userDto);
        return new RedirectView("/login/");
    }
}
