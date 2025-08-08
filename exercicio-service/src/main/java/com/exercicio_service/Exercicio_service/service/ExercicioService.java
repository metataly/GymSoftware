package com.exercicio_service.Exercicio_service.service;

import com.exercicio_service.Exercicio_service.dto.ExercicioDto;
import com.exercicio_service.Exercicio_service.model.Exercicio;
import com.exercicio_service.Exercicio_service.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;

    public ExercicioService (ExercicioRepository exercicioRepository){
        this.exercicioRepository = exercicioRepository;
    }


    //Post
    public Exercicio cadastro (ExercicioDto exercicioDto){
        Exercicio exercicio = new Exercicio();

        exercicio.setId(exercicioDto.getId());
        exercicio.setNome(exercicioDto.getNome());
        exercicio.setEquipamento(exercicioDto.getEquipamento());
        exercicio.setGrupoMuscular(exercicioDto.getGrupoMuscular());
        exercicio.setSeries(exercicioDto.getSeries());

        return exercicioRepository.save(exercicio);

    }

    //get {id}
    public Exercicio buscarExercicio (UUID id){

        return exercicioRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercicio não encontrado!"));

    }

    public List<Exercicio> exibirExercicios (){
        return exercicioRepository.findAll();
    }
}
