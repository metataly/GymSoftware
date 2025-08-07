package com.aluno_service.aluno_service.controller;

import com.aluno_service.aluno_service.dto.AlunoDto;
import com.aluno_service.aluno_service.model.Aluno;
import com.aluno_service.aluno_service.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController (AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar (@RequestBody @Valid AlunoDto alunoDto){
        try{
            Aluno aluno = alunoService.cadastro(alunoDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar (@PathVariable UUID id){
        try{
            Aluno aluno = alunoService.buscarAluno(id);
            return ResponseEntity.status(HttpStatus.OK).body(aluno);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/exibir")
    public ResponseEntity<List<Aluno>> exibir (){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.exibirAlunos());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar (@RequestBody @Valid AlunoDto alunoDto, @PathVariable UUID id){
        try{
            Aluno aluno = alunoService.atualizar(alunoDto, id);

            return ResponseEntity.status(HttpStatus.OK).body(aluno);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/desativar/{id}")
    public ResponseEntity<?> desativar (@PathVariable UUID id){
        try{
            Aluno aluno = alunoService.desligar(id);
            return ResponseEntity.status(HttpStatus.OK).body(aluno);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
