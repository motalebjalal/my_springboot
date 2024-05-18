package com.jalal.security_stepfour.security_service;

import com.jalal.security_stepfour.entity.UserEntity;
import com.jalal.security_stepfour.repository.UserEntityRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserEntityRepo userEntityRepo;

    public CustomUserDetailsService(UserEntityRepo userEntityRepo) {
        this.userEntityRepo = userEntityRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userEntityRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " is not found!");
        }
        return new UserPrincipal(user);
    }
}
