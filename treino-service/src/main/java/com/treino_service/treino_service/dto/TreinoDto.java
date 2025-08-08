package com.treino_service.treino_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreinoDto {

    private UUID id;
    private UUID idAluno;

    @NotBlank
    private String nome;

    private String objetivo;

    private UUID idInstrutor;
    private List<UUID> listaExercicios;

}
