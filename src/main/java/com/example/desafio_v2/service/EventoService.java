package com.example.desafio_v2.service;


import java.util.List;
import java.util.Optional;

import com.example.desafio_v2.exception.DataNotFoundException;
import com.example.desafio_v2.domain.entities.Evento;
import com.example.desafio_v2.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

//n fazer nos satatus
public Evento createEvento(Evento model) {
    return eventoRepository.save(model);
}


public List<Evento> listEvento() {
    return eventoRepository.findAll();
}

public Evento findById(Integer id) {
    Optional<Evento> evento = eventoRepository.findById(id);
    return evento.orElseThrow(() -> new DataNotFoundException("Client Not found"));
}


//n fazer nos satatus
 public void deleteEvento(Integer id) {
    eventoRepository.deleteById(id);
     //listClient();
    
} 
//n fazer nos satatus
public Evento updateEvento(Integer id, Evento newEvento) {
    Evento evento = findById(id);

    evento.setNome(newEvento.getNome());
    //evento.setlocal(newEvento.getlocal());

   return eventoRepository.save(evento);
   
} 

public  List<String> listDistinct() {
    return eventoRepository.listDistinct();

}


/* public Evento iniciarEvento(Integer id, 2){
    
    return 

} */
}