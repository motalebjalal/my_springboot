package com.jalal.security_stepjwt3.user_service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

//    public static final String SECRET = "Ay$bgkalak393484839-847463|#$%$%#@@THGFRRHEERFGT"; //its for manually key generate

    //generate random key area start here
    private String secretKey;

    public JwtService() {
        secretKey = generateSecretKey();
    }

    //generate random key method
    public String generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("secret key" + secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating SecretKey" + e);
        }
    }

    //generate random key area end here

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        claims.put("iat", System.currentTimeMillis());
        claims.put("exp", System.currentTimeMillis() + 1000*60*70);
        claims.put("sub", username);
        claims.put("iss", "https://localhost:6066");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .signWith(getKey(), SignatureAlgorithm.HS256).compact();
    }

    
    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Token extract start area here

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);

    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build().parseClaimsJws(token).getBody();
    }



    //validate area start here
    public boolean validateToken(String token, UserDetails userDetails) {

        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        System.out.println("token expiration check " + token);
        return extractClaims(token, Claims::getExpiration);
    }


}

