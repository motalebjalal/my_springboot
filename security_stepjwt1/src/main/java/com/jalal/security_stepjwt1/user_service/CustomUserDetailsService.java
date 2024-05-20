package com.jalal.security_stepjwt1.user_service;

import com.jalal.security_stepjwt1.domain.UserPrincipal;
import com.jalal.security_stepjwt1.entity.UserEntity;
import com.jalal.security_stepjwt1.repository.UserEntityRepo;
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
