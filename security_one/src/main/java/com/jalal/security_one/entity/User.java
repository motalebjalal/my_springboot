package com.jalal.security_one.entity;

import lombok.Data;
@Data
public class User {

    private Long id;

    private String userName;
    private String password;
    private String role;
}
