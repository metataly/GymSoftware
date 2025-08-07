package com.auth_service.auth_service.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

public class JwtController {
    @Value("${jwt.public.key}")
    private RSAPublicKey publicKey;

    @GetMapping("/.well-known/jwks.json")
    public Map<String, Object> getKey() {
       RSAKey key = new RSAKey.Builder(publicKey).build();

       return new JWKSet(key).toJSONObject();
    }
}
