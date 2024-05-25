package com.jalal.security_stepjwt3.user_service;


import com.jalal.security_stepjwt3.entity.UserEntity;
import com.jalal.security_stepjwt3.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jalal.security_stepjwt3.securityconfig.WebSecurityConfig.passwordEncoder;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    private UserEntityRepo userEntityRepo;

    @Override
    public UserEntity saveUser(UserEntity user) {
        String encodedPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userEntityRepo.save(user);
    }


}

