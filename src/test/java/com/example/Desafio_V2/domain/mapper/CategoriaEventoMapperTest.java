package com.example.Desafio_V2.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.example.desafio_v2.configuration.MapperConfig;
import com.example.desafio_v2.domain.dto.request.CategoriaEventoRequest;
import com.example.desafio_v2.domain.dto.response.CategoriaEventoResponse;
import com.example.desafio_v2.domain.entities.CategoriaEvento;
import com.example.desafio_v2.domain.mapper.CategoriaEventoMapper;

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
public class CategoriaEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private CategoriaEventoMapper mapper;

    @Test
    public void shouldConvertClientToClientResponse() {
        CategoriaEvento entity = CategoriaEvento.builder().IdCategoriaEvento(1).NomeCategoria("name").build();
        CategoriaEventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdCategoriaEvento(), entity.getIdCategoriaEvento());
        assertEquals("Unexpected value found!", dto.getNomeCategoria(), entity.getNomeCategoria());

    }

    @Test
    public void shouldConvertClientCreateRequestToClient() {
        CategoriaEventoRequest dto = CategoriaEventoRequest.builder().NomeCategoria("name").build();

        CategoriaEvento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNomeCategoria(), entity.getNomeCategoria());
    }

}