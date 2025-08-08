package com.exercicio_service.Exercicio_service.repository;

import com.exercicio_service.Exercicio_service.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExercicioRepository extends JpaRepository<Exercicio, UUID> {

}

