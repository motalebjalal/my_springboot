package com.jalal.security_stepjwt1.user_service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtService {
    public static final String SECRET = "Ay$bgkalak393484839-847463|#$%$%#@@THGFRRHEERFGT";
    
    public String generateToken(String username){

        Map<String, Object> claims = new HashMap<>();

        claims.put("iat", System.currentTimeMillis());
        claims.put("exp", System.currentTimeMillis() + 1000 + 60 + 3);
        claims.put("sub", username);
        claims.put("iss", "https://localhost:6065");

        SecretKey key = this.getKey();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .signWith(key)
                .compact();

    }
    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
}
