package com.example.desafio_v2.domain.mapper;

import com.example.desafio_v2.domain.dto.request.CategoriaEventoRequest;
import com.example.desafio_v2.domain.dto.response.CategoriaEventoResponse;
import com.example.desafio_v2.domain.entities.CategoriaEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaEventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public CategoriaEventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CategoriaEventoResponse toDto(CategoriaEvento input) {
        return mapper.map(input, CategoriaEventoResponse.class);
    }

    public CategoriaEvento fromDto(CategoriaEventoRequest input) {
        return mapper.map(input, CategoriaEvento.class);
    }

    public CategoriaEvento DELETE(CategoriaEventoRequest input) {
        return mapper.map(input, CategoriaEvento.class);
    }



}
