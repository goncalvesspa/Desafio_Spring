package com.example.desafio_v2.service;


import java.util.List;
import java.util.Optional;

import com.example.desafio_v2.exception.DataNotFoundException;

import com.example.desafio_v2.domain.entities.CategoriaEvento;
import com.example.desafio_v2.repository.CategoriaEventoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEventoService {

    private final CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository) {
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

//n fazer nos satatus
    public CategoriaEvento createCategoriaEvento(CategoriaEvento model) {
        return categoriaEventoRepository.save(model);
    }


    public List<CategoriaEvento> listCategoriaEvento() {
        return categoriaEventoRepository.findAll();
    }

    public CategoriaEvento findById(Integer id) {
        Optional<CategoriaEvento> categoriaEvento = categoriaEventoRepository.findById(id);
        return categoriaEvento.orElseThrow(() -> new DataNotFoundException("Evento Not found"));
    }
    

        
    
//n fazer nos satatus
  
   public  List<String> listDistinct() {
    return categoriaEventoRepository.listDistinct();
}


}