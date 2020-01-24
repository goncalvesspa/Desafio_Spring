package com.example.desafio_v2.service;


import java.util.List;
import java.util.Optional;

import com.example.desafio_v2.exception.DataNotFoundException;
import com.example.desafio_v2.domain.entities.StatusEvento;
import com.example.desafio_v2.repository.StatusEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusEventoService {

    private final StatusEventoRepository statusEventoRepository;

    @Autowired
    public StatusEventoService(StatusEventoRepository statusEventoRepository) {
        this.statusEventoRepository = statusEventoRepository;
    }

//n fazer nos satatus
    public StatusEvento createStatusEvento(StatusEvento model) {
        return statusEventoRepository.save(model);
    }


    public List<StatusEvento> listStatusEvento() {
        return statusEventoRepository.findAll();
    }

    public StatusEvento findById(Integer id) {
        Optional<StatusEvento> statusEvento = statusEventoRepository.findById(id);
        return statusEvento.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }
    

        
    
//n fazer nos satatus
  
   public  List<String> listDistinct() {
    return statusEventoRepository.listDistinct();
}


}