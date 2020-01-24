package com.example.Desafio_V2.domain.maper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.example.desafio_v2.configuration.MapperConfig;
import com.example.desafio_v2.domain.dto.response.EventoResponse;
import com.example.desafio_v2.domain.entities.Evento;
import com.example.desafio_v2.domain.mapper.EventoMapper;


 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;


@RunWith(MockitoJUnitRunner.class)
public class EventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private EventoMapper mapper;

    @Test
    public void shouldConvertClientToClientResponse() {
        Evento entity = Evento.builder().idEvento(1).nome("name").dataHoraInicio(new Date()).dataHoraFim(new Date()).local("Rua Iteris").descricao("Evento show").limiteVagas(1).build();
        EventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdEvento(), entity.getIdEvento());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
       // assertEquals("Unexpected value found!", dto.getPhone(), entity.getPhone());
    }



}