package com.auth_service.auth_service.dto;

import com.auth_service.auth_service.enuns.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDto {

    private UUID id;
    private String nome;
    private String email;
    private Role role;

}
