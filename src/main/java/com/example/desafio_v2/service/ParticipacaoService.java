package com.example.desafio_v2.service;


import java.util.List;
import java.util.Optional;

import com.example.desafio_v2.exception.DataNotFoundException;
import com.example.desafio_v2.domain.entities.Participacao;
import com.example.desafio_v2.repository.ParticipacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacaoService {

    private final ParticipacaoRepository participacaoRepository;

    @Autowired
    public ParticipacaoService(ParticipacaoRepository participacaoRepository) {
        this.participacaoRepository = participacaoRepository;
    }

//n fazer nos satatus
public Participacao createParticipacao(Participacao model) {
    return participacaoRepository.save(model);
}


public List<Participacao> listParticipacao() {
    return participacaoRepository.findAll();
}

public Participacao findById(Integer id) {
    Optional<Participacao> participacao = participacaoRepository.findById(id);
    return participacao.orElseThrow(() -> new DataNotFoundException("Client Not found"));
}


//n fazer nos satatus
 public void deleteParticipacao(Integer id) {
    participacaoRepository.deleteById(id);
     //listClient();
    
} 
public Participacao updateParticipacao(Integer id, Participacao newParticipacao) {
    Participacao participacao = findById(id);

    participacao.setLoginParticipante(newParticipacao.getLoginParticipante());
    participacao.setNota(newParticipacao.getNota());

   return participacaoRepository.save(participacao);
   
} 



public  List<String> listDistinct() {
return participacaoRepository.listDistinct();
}


}