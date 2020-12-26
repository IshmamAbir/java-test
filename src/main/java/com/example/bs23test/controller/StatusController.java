package com.example.bs23test.controller;

import com.example.bs23test.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService service;

    @GetMapping("/public-status")
    public String showPublicStatus(Model model){
        model.addAttribute("statusList",service.getAllPublicStatus());

        return "status/all-status";
    }

    @GetMapping("/private-status")
    public String showPrivateStatus(Model model){
        model.addAttribute("statusList",service.getAllPrivateStatus());

        return "status/all-status";
    }
}
