package com.jalal.security_stepfour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/login")
    public String login(){
        System.out.println(" login page ");
        return "login";
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

    @GetMapping("/error/403")
    public String errorPage(){
        return "403";
    }


}
