package com.treino_service.treino_service.controller;

import com.treino_service.treino_service.dto.TreinoDto;
import com.treino_service.treino_service.model.Treino;
import com.treino_service.treino_service.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/treino")
public class TreinoController {
    private final TreinoService treinoService;

    public TreinoController (TreinoService treinoService){
        this.treinoService = treinoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar (@RequestBody @Valid TreinoDto treinoDto){
        try{
            Treino treino = treinoService.cadastro(treinoDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(treino);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar (@PathVariable UUID id){
        try{
            Treino treino = treinoService.buscarTreino(id);
            return ResponseEntity.status(HttpStatus.OK).body(treino);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/exibir")
    public ResponseEntity<List<Treino>> exibir (){
        List<Treino> treinos = treinoService.exibirTreinos();
        return ResponseEntity.status(HttpStatus.OK).body(treinos);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar (@RequestBody @Valid TreinoDto treinoDto, @PathVariable UUID id){
        try{
            Treino treino = treinoService.atualizar(treinoDto, id);

            return ResponseEntity.status(HttpStatus.OK).body(treino);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
