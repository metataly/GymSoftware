package com.exercicio_service.Exercicio_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExercicioDto {
    private String id;

    @NotBlank
    private String nome;

    private String equipamento;

    @NotBlank
    private String grupoMuscular;

    private String series;

}
