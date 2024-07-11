/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.uv.Abarrotes.security.JwtKeyProvider;

/**
 *
 * @author wbpat
 */
@Component
public class JwtUtil {

    @Autowired
    private JwtKeyProvider jwtKeyProvider;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, jwtKeyProvider.getEncodedSecretKey())
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(jwtKeyProvider.getEncodedSecretKey()).parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtKeyProvider.getEncodedSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        return extractClaims(token).getExpiration().after(new Date());
    }
}
