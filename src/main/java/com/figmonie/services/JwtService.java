package com.figmonie.services;

import com.figmonie.data.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService  {

    private final SecretKey key = Keys
            .hmacShaKeyFor("06904e8dc8b08f33602356eb35f78f8fc32284d09688a199ce463be4692c9626"
                    .getBytes());

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaim(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaim(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String authToken) {
        return extractExpiration(authToken).before(new Date());
    }

    public Date extractExpiration(String authToken) {
        Claims claims = extractAllClaim(authToken);
        return claims.getExpiration();
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .subject(user.getId())
                .claim("username", user.getUsername())
                .claim("role", user.getRole())
                .claim("email", user.getEmail())
                .signWith(key)
                .compact();
    }
}
