package com.treino_service.treino_service.service;


import com.treino_service.treino_service.dto.TreinoDto;
import com.treino_service.treino_service.model.Treino;
import com.treino_service.treino_service.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TreinoService {
    private final TreinoRepository treinoRepository;

    public TreinoService (TreinoRepository treinoRepository){
        this.treinoRepository = treinoRepository;
    }


    //Post
    public Treino cadastro (TreinoDto treinoDto){
        Treino treino = new Treino();

        treino.setNome(treinoDto.getNome());
        treino.setObjetivo(treinoDto.getObjetivo());
        treino.setIdInstrutor(treinoDto.getIdInstrutor());
        treino.setListaExercicios(treinoDto.getListaExercicios());

        return treinoRepository.save(treino);

    }

    //get {id}
    public Treino buscarTreino (UUID id){

        return treinoRepository.findById(id).orElseThrow(() -> new RuntimeException("Treino não encontrado!"));

    }

    //get{id}
    public List<Treino> exibirTreinos (){
        return treinoRepository.findAll();
    }

    //Put {id}
    public Treino atualizar (TreinoDto treinoDto, UUID id){
        Treino treino = buscarTreino(id);

        treino.setNome(treinoDto.getNome());
        treino.setObjetivo(treinoDto.getObjetivo());
        treino.setIdInstrutor(treinoDto.getIdInstrutor());
        treino.setListaExercicios(treinoDto.getListaExercicios());

        return treinoRepository.save(treino);
    }
}
