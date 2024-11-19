package com.gamodel.galeriavirtual.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import com.gamodel.galeriavirtual.model.Usuario;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JWTUtil {

    private final String SECRET_KEY = "ClaveSecreta123ClaveSecreta123ClaveSecreta123ClaveSecreta123";

    private final Key signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(String username, String role) {
        try {
            return Jwts.builder()
                    .setSubject(username)
                    .claim("role", role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                    .signWith(signingKey, SignatureAlgorithm.HS512)
                    .compact();
        } catch (Exception e) {
            e.printStackTrace();

            throw new RuntimeException("Error generando token", e);
        }
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public boolean validateToken(String token, Usuario usuario) {
        final String username = extractUsername(token);
        return username.equals(usuario.getCorreo()) && !isTokenExpired(token);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}