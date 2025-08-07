package com.auth_service.auth_service.service;

import com.auth_service.auth_service.enuns.Role;
import com.auth_service.auth_service.model.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(User user, Role role) {
        Instant now = Instant.now();
        long expiresIn = 3600L;

        String roleName = "ROLE_" + role.name();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("auth-service")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .subject(user.getEmail())
                .claim("scope", roleName)
                .build();


        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
