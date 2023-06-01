package ru.authservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.authservice.application.auth.model.CustomerDto;
import ru.authservice.configuration.JwtConfig;

@Component
@RequiredArgsConstructor
public class JwtUtils {
    private final JwtConfig jwtConfig;

    private final ObjectMapper objectMapper;

    public String generateToken(CustomerDto customerDto) {
        try {
            Date now = new Date();
            Date exp = Date.from(LocalDateTime.now().plusHours(jwtConfig.getTimeOfActionAuthToken())
                    .atZone(ZoneId.systemDefault()).toInstant());
            return Jwts.builder()
                    .setSubject(objectMapper.writeValueAsString(customerDto))
                    .setIssuedAt(now)
                    .setNotBefore(now)
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, jwtConfig.getJwtSecret())
                    .compact();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtConfig.getJwtSecret())
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getWordForToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtConfig.getJwtSecret())
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
