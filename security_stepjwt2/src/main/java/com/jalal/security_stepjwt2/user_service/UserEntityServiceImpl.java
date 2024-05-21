package com.jalal.security_stepjwt2.user_service;


import com.jalal.security_stepjwt2.entity.UserEntity;
import com.jalal.security_stepjwt2.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jalal.security_stepjwt2.securityconfig.WebSecurityConfig.passwordEncoder;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    private UserEntityRepo userEntityRepo;




    @Override
    public String saveUser(UserEntity user) {

        String encodedPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        userEntityRepo.save(user);
        return user.getUsername();
    }


}
