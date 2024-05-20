package com.jalal.securitystepjwt2.user_service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

//    public static final String SECRET = "Ay$bgkalak393484839-847463|#$%$%#@@THGFRRHEERFGT"; //its for manually key generate

    //generate random key area start here
    private final String key;

    public JwtService(){
        this.key = generateSecretKey();
    }

    //generate random key method
    public String generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("secret key" + secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }catch ( NoSuchAlgorithmException e){
            throw new RuntimeException("Error generating SecretKey"+e);
        }
    }

    //generate random key area end here

    public String generateToken(String username){

        Map<String, Object> claims = new HashMap<>();

        claims.put("iat", System.currentTimeMillis());
        claims.put("exp", System.currentTimeMillis() + 1000 + 60 + 3);
        claims.put("sub", username);
        claims.put("iss", "https://localhost:6065");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, key).compact();

    }

}
