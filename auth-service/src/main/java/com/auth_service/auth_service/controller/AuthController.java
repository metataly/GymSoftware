package com.auth_service.auth_service.controller;

import com.auth_service.auth_service.dto.AuthDto;
import com.auth_service.auth_service.dto.RegisterDto;
import com.auth_service.auth_service.dto.ResponseDto;
import com.auth_service.auth_service.service.AuthService;
import com.auth_service.auth_service.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {

    private AuthService authService;
    private JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService){
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin (@RequestBody @Valid AuthDto authDto){

        try{
            String tokenJwt = authService.userLogin(authDto);

            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenJwt).body("Login realizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> userRegister (@RequestBody @Valid RegisterDto registerDto){

        ResponseDto response = authService.userRegister(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}
