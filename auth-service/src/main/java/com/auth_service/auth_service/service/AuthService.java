package com.auth_service.auth_service.service;

import com.auth_service.auth_service.dto.AuthDto;
import com.auth_service.auth_service.dto.RegisterDto;
import com.auth_service.auth_service.dto.ResponseDto;
import com.auth_service.auth_service.enuns.Role;
import com.auth_service.auth_service.model.User;
import com.auth_service.auth_service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //persistindo dados
    private UserRepository userRepository;
    private JwtService jwtService;

    public AuthService (UserRepository userRepository, JwtService jwtService){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String userLogin (AuthDto authDto){
        User user = userRepository.findByEmail(authDto.getEmail()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if(!user.getPassword().equals(authDto.getPassword())){
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

        User user = new User(null, registerDto.getNome(), registerDto.getEmail(), registerDto.getPassword(), registerDto.getRole());
        userRepository.save(user);

        return new ResponseDto(user.getId(), user.getNome(), user.getEmail(), user.getRole());
    }

}
