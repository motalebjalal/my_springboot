package com.jalal.security_stepjwt2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "authority")
    String authority;


}
