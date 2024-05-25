package com.jalal.security_stepjwt3.controller;

import com.jalal.security_stepjwt3.entity.UserEntity;
import com.jalal.security_stepjwt3.user_service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/user")
    public String user() {
        return "Welcome to user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to admin";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(user.getUsername());
            }
        } catch (Exception e) {
            return "Invalid username or password";
        }
        return "User not logged in";
    }


}

