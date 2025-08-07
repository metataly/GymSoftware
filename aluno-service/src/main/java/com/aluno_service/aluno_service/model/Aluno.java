package com.aluno_service.aluno_service.model;

import com.aluno_service.aluno_service.enuns.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "alunos")

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Status status;
}
