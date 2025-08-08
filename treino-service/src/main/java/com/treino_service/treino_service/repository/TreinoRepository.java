package com.treino_service.treino_service.repository;

import com.treino_service.treino_service.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreinoRepository extends JpaRepository<Treino, UUID> {

}