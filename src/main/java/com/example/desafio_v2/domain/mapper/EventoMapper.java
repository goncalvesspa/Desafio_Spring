package com.example.desafio_v2.domain.mapper;


import com.example.desafio_v2.domain.dto.request.EventoRequest;
import com.example.desafio_v2.domain.dto.response.EventoResponse;
import com.example.desafio_v2.domain.entities.Evento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public EventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public EventoResponse toDto(Evento input) {
        return mapper.map(input, EventoResponse.class);
    }

    public Evento fromDto(EventoRequest input) {
        return mapper.map(input, Evento.class);
    }

    /* public Evento fromDto2(EventoUpdate input) {
        return mapper.map(input, Evento.class);
    } */


    public Evento DELETE(EventoRequest input) {
        return mapper.map(input, Evento.class);
    }



}
