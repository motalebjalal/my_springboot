package com.jalal.security_stepfour.repository;

import com.jalal.security_stepfour.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
