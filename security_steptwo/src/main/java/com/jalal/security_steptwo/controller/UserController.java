package com.jalal.security_steptwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping({"/","/home"})
    public String Home(){
        System.out.println("home page");
        return "home";
    }

    @GetMapping("/user")
    public String userPage(){
        System.out.println("user page");
        return "user";
    }

    @GetMapping("/admin")
    public String adminPage(){
        System.out.println("admin page");
        return "admin";
    }


}
