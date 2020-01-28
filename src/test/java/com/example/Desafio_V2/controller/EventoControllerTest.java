package com.example.Desafio_V2.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import com.example.desafio_v2.controller.EventoController;
import com.example.desafio_v2.domain.dto.request.EventoRequest;
import com.example.desafio_v2.domain.dto.response.EventoResponse;
import com.example.desafio_v2.domain.entities.CategoriaEvento;
import com.example.desafio_v2.domain.entities.Evento;
import com.example.desafio_v2.domain.entities.StatusEvento;
import com.example.desafio_v2.domain.mapper.EventoMapper;
import com.example.desafio_v2.service.EventoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * ClientControllerTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoControllerTest {

    @Mock
    private EventoMapper mapper;

    @Mock
    private EventoService service;

    @InjectMocks
    private EventoController controller;

    private final Integer idEvento = 1;
    private final String nome = "Bruno";
    private final Date dataHoraInicio = new Date();


    StatusEvento entity2 = StatusEvento.builder().IdEventoStatus(1).build();
    CategoriaEvento entity3 = CategoriaEvento.builder().IdCategoriaEvento(1).build();
    Evento entity = Evento.builder().idEvento(idEvento).idEventoStatus(entity2).idCategoriaEvento(entity3).nome(nome).dataHoraInicio(dataHoraInicio).build();


    EventoRequest createDto = EventoRequest.builder().nome(nome).dataHoraInicio(dataHoraInicio).build();

    EventoResponse responseDto = EventoResponse.builder().idEvento(idEvento).idEventoStatus(entity2).idCategoriaEvento(entity3).nome(nome).dataHoraInicio(dataHoraInicio).build();




    @Test
    public void should_GetById() {
        //given
        when(service.findById(any())).thenReturn(entity);
        when(mapper.toDto(any())).thenReturn(responseDto);


        // when
        ResponseEntity<EventoResponse> response = controller.getById(1);

        //then
        assertEquals("Deve ser 0k /200", response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void should_Created_WhenInvalid() {
        //given
        when(mapper.fromDto(any())).thenReturn(entity);
        when(service.createEvento(any())).thenReturn(entity);
        when(mapper.toDto(any())).thenReturn(responseDto);

        // when
        ResponseEntity<EventoResponse> response = controller.post(createDto);

        //then
        assertEquals("Deve ser 0k /200", response.getStatusCode(), HttpStatus.OK);
    }
}

// antes dos 15 min do audio