package com.example.Desafio_V2.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import com.example.desafio_v2.domain.entities.CategoriaEvento;

import com.example.desafio_v2.exception.DataNotFoundException;
import com.example.desafio_v2.repository.CategoriaEventoRepository;
import com.example.desafio_v2.service.CategoriaEventoService;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * ClientServiceTest
 */

@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoServiceTeste {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private CategoriaEventoRepository repositoryMock;

    @InjectMocks
    private CategoriaEventoService service;


    

    private final Integer IdCategoriaEvento = 1; //Valor mocado
    private String NomeCategoria = "Front";
    
    /* private final String nome = "Some string";
    private final Integer limiteVagas = 1;
    private final Date dataHoraInicio = new Date();
    private final Date dataHoraFim = new Date();
    private final String local = "Rua Iteris";
    private final String descricao = "Evento Front";
 */


    CategoriaEvento categoriaEvento = CategoriaEvento.builder().IdCategoriaEvento(IdCategoriaEvento).NomeCategoria(NomeCategoria).build(); 

    

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Evento Not found");

        // when
        service.findById(4);
    }

    @Test
    public void should_findById() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(categoriaEvento));

        // when
        CategoriaEvento model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<CategoriaEvento> list = new ArrayList<>();
        list.add(categoriaEvento);
        when(repositoryMock.findAll()).thenReturn(list);

        List<CategoriaEvento> listR = service.listCategoriaEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

}