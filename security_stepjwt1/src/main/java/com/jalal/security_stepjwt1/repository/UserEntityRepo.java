package com.jalal.security_stepjwt1.repository;

import com.jalal.security_stepjwt1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
