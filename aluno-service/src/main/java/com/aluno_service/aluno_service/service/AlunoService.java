package com.aluno_service.aluno_service.service;

import com.aluno_service.aluno_service.dto.AlunoDto;
import com.aluno_service.aluno_service.enuns.Status;
import com.aluno_service.aluno_service.model.Aluno;
import com.aluno_service.aluno_service.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService (AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }


    //Post
    public Aluno cadastro (AlunoDto alunoDto){
        Aluno aluno = new Aluno();

        aluno.setId(alunoDto.getId());
        aluno.setNome(alunoDto.getNome());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setTelefone(alunoDto.getTelefone());
        aluno.setDataNascimento(alunoDto.getDataNascimento());
        aluno.setStatus(Status.ATIVO);

        return alunoRepository.save(aluno);

    }

    //get {id}
    public Aluno buscarAluno (UUID id){

        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

    }

    //get{id}
    public List<Aluno> exibirAlunos (){
        return alunoRepository.findByStatus(Status.ATIVO);
    }

    //Put {id}
    public Aluno atualizar (AlunoDto alunoDto, UUID id){
        Aluno aluno = buscarAluno(id);

        aluno.setNome(alunoDto.getNome());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setTelefone(alunoDto.getTelefone());
        aluno.setDataNascimento(alunoDto.getDataNascimento());

        //para reativar se necessário
        aluno.setStatus(alunoDto.getStatus());

        return alunoRepository.save(aluno);
    }

    //Delete {id}
    public Aluno desligar (UUID id){

        Aluno aluno = buscarAluno(id);

        aluno.setStatus(Status.INATIVO);

        return alunoRepository.save(aluno);
    }
}
