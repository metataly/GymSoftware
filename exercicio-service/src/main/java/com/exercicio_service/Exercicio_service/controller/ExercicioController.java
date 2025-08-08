package com.exercicio_service.Exercicio_service.controller;

import com.exercicio_service.Exercicio_service.dto.ExercicioDto;
import com.exercicio_service.Exercicio_service.model.Exercicio;
import com.exercicio_service.Exercicio_service.service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Exercicio")
public class ExercicioController {
    private final ExercicioService exercicioService;

    public ExercicioController (ExercicioService exercicioService){
        this.exercicioService = exercicioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar (@RequestBody @Valid ExercicioDto exercicioDto){
        try{
            Exercicio exercicio = exercicioService.cadastro(exercicioDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar (@PathVariable UUID id){
        try{
            Exercicio exercicio = exercicioService.buscarExercicio(id);
            return ResponseEntity.status(HttpStatus.OK).body(exercicio);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/exibir")
    public ResponseEntity<List<Exercicio>> exibir (){
        return ResponseEntity.status(HttpStatus.OK).body(exercicioService.exibirExercicios());
    }
}
