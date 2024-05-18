package com.jalal.security_stepfour.user_service;


import com.jalal.security_stepfour.entity.UserEntity;
import com.jalal.security_stepfour.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jalal.security_stepfour.securityconfig.WebSecurityConfig.passwordEncoder;

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
