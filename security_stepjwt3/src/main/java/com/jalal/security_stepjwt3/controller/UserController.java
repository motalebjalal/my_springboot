package com.jalal.security_stepjwt3.controller;

import com.jalal.security_stepjwt3.entity.UserEntity;
import com.jalal.security_stepjwt3.user_service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserEntityService userEntityService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
        user.setAuthority("ROLE_USER");  // direct set in code
        //user.setAuthority("ROLE_ADMIN");  // direct set in code
        UserEntity newUser = userEntityService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

}

