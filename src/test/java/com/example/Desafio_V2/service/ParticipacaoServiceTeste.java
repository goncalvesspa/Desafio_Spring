package com.example.Desafio_V2.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.desafio_v2.domain.entities.CategoriaEvento;
import com.example.desafio_v2.domain.entities.Evento;
import com.example.desafio_v2.domain.entities.Participacao;
import com.example.desafio_v2.exception.DataNotFoundException;
import com.example.desafio_v2.repository.EventoRepository;
import com.example.desafio_v2.repository.ParticipacaoRepository;
import com.example.desafio_v2.service.EventoService;
import com.example.desafio_v2.service.ParticipacaoService;

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
public class ParticipacaoServiceTeste {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ParticipacaoRepository repositoryMock;

    @InjectMocks
    private ParticipacaoService service;


    private final Integer IdParticipacao = 1;
    private final int Nota = 1;
    private final String LoginParticipante = "Some string";
    private final String Comentario = "Rua Iteris";
    



    Participacao participacao = Participacao.builder().IdParticipacao(IdParticipacao).Nota(Nota).build(); 

    Evento entity = Evento.builder().idEvento(idEvento).nome(nome).limiteVagas(limiteVagas).dataHoraInicio(dataHoraInicio).dataHoraFim(dataHoraFim).local(local).descricao(descricao).build();

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
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Evento model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Evento> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Evento> listR = service.listEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

}