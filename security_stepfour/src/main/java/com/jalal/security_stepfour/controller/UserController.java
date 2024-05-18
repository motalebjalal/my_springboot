package com.jalal.security_stepfour.controller;

import com.jalal.security_stepfour.entity.UserEntity;
import com.jalal.security_stepfour.user_service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserEntityService userEntityService;

    @GetMapping({"/","/home"})
    public String Home(){
        System.out.println("home page");
        return "home";
    }

    @GetMapping("/form")
    public String regForm() {
        return "form";
    }

    @PostMapping("/create")
    public String registration(UserEntity user) {
        user.setAuthority("ROLE_USER");  // direct set in code
        //user.setAuthority("ROLE_ADMIN");  // direct set in code
        userEntityService.saveUser(user);
        return "form";
    }

}
