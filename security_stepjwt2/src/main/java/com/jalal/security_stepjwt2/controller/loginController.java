package com.jalal.security_stepjwt2.controller;

import com.jalal.security_stepjwt2.entity.UserEntity;
import com.jalal.security_stepjwt2.user_service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class loginController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){
        System.out.println(" login page ");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
            );
            if (authentication.isAuthenticated()){
                return jwtService.generateToken(user.getUsername());
            }
        }catch (Exception e){
            return "Invalid username and password";
        }

        return "user not loged in";
    }

}
