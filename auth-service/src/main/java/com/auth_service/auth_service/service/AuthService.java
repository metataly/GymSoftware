package com.auth_service.auth_service.service;

import com.auth_service.auth_service.dto.AuthDto;
import com.auth_service.auth_service.dto.RegisterDto;
import com.auth_service.auth_service.dto.ResponseDto;
import com.auth_service.auth_service.enuns.Role;
import com.auth_service.auth_service.model.User;
import com.auth_service.auth_service.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //persistindo dados
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService (UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }


    public String userLogin (AuthDto authDto){
        User user = userRepository.findByEmail(authDto.getEmail()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if(!passwordEncoder.matches(authDto.getPassword(), user.getPassword())){
            throw new RuntimeException("Senha incorreta!");
        }


        Role role = user.getRole();
        String token = jwtService.generateToken(user, role);

        return token;
    }

    public ResponseDto userRegister (RegisterDto registerDto){
        if (userRepository.findByEmail(registerDto.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado!");
        }

        User user = new User(null, registerDto.getNome(), registerDto.getEmail(), passwordEncoder.encode(registerDto.getPassword()), registerDto.getRole());
        userRepository.save(user);

        return new ResponseDto(user.getId(), user.getNome(), user.getEmail(), user.getRole());
    }

}
