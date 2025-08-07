package com.aluno_service.aluno_service.repository;

import com.aluno_service.aluno_service.enuns.Status;
import com.aluno_service.aluno_service.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    List<Aluno> findByStatus(Status status);
    Optional<Aluno> findByEmail (String email);
}
