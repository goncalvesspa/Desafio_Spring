package com.example.Desafio_V2.domain.mapper;

import static org.junit.Assert.assertEquals;


import com.example.desafio_v2.configuration.MapperConfig;
import com.example.desafio_v2.domain.dto.request.StatusEventoRequest;
import com.example.desafio_v2.domain.dto.response.StatusEventoResponse;
import com.example.desafio_v2.domain.entities.StatusEvento;
import com.example.desafio_v2.domain.mapper.StatusEventoMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * ClientMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private StatusEventoMapper mapper;
    

    @Test
    public void shouldConvertClientToClientResponse() {

        StatusEvento entity = StatusEvento.builder().IdEventoStatus(1).NomeStatus("F").build();
        StatusEventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdEventoStatus(), entity.getIdEventoStatus());
        assertEquals("Unexpected value found!", dto.getNomeStatus(), entity.getNomeStatus());
        
    }

    @Test
    public void shouldConvertClientCreateRequestToClient() {
        
        StatusEventoRequest dto = StatusEventoRequest.builder().NomeStatus("F").build();
        StatusEvento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNomeStatus(), entity.getNomeStatus());
    }

}