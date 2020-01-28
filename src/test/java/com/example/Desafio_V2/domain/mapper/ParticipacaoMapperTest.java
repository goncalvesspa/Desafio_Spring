package com.example.Desafio_V2.domain.mapper;

import static org.junit.Assert.assertEquals;



import com.example.desafio_v2.configuration.MapperConfig;
import com.example.desafio_v2.domain.dto.request.ParticipacaoRequest;
import com.example.desafio_v2.domain.dto.response.ParticipacaoResponse;
import com.example.desafio_v2.domain.entities.Evento;
import com.example.desafio_v2.domain.entities.Participacao;
import com.example.desafio_v2.domain.mapper.ParticipacaoMapper;

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
public class ParticipacaoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private ParticipacaoMapper mapper;
    

    @Test
    public void shouldConvertClientToClientResponse() {
        Evento entity2 = Evento.builder().idEvento(1).build();
        Participacao entity = Participacao.builder().IdParticipacao(1).IdEvento(entity2).LoginParticipante("F").FlagPresente(true).Nota(2).Comentario("Show").build();
        //CategoriaEvento entity3 = CategoriaEvento.builder().IdCategoriaEvento(1).build();
        ParticipacaoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdParticipacao(), entity.getIdParticipacao());
        assertEquals("Unexpected value found!", dto.getIdEvento(), entity.getIdEvento());
        assertEquals("Unexpected value found!", dto.getLoginParticipante(), entity.getLoginParticipante());
        assertEquals("Unexpected value found!", dto.getFlagPresente(), entity.getFlagPresente());
        assertEquals("Unexpected value found!", dto.getNota(), entity.getNota());
        assertEquals("Unexpected value found!", dto.getComentario(), entity.getComentario());
    }

    @Test
    public void shouldConvertClientCreateRequestToClient() {
        //Evento entity2 = Evento.builder().idEvento(1).nome("f").dataHoraInicio(new Date()).dataHoraFim(new Date()).local("Rua Iteris").build();
        //CategoriaEvento entity3 = CategoriaEvento.builder().IdCategoriaEvento(1).build();
        ParticipacaoRequest dto = ParticipacaoRequest.builder().IdEvento(1).LoginParticipante("F").FlagPresente(true).Nota(1).Comentario("show").build();
       
        //idEventoStatus(1).idCategoriaEvento(1).nome("f").dataHoraInicio(new Date()).dataHoraFim(new Date()).local("Rua Iteris").

        Participacao entity = mapper.fromDto(dto);

        //assertEquals("Unexpected value found!", dto.getIdEvento(), entity.getIdEvento());
        assertEquals("Unexpected value found!", dto.getLoginParticipante(), entity.getLoginParticipante());
        assertEquals("Unexpected value found!", dto.getFlagPresente(), entity.getFlagPresente());
        assertEquals("Unexpected value found!", dto.getNota(), entity.getNota());
        assertEquals("Unexpected value found!", dto.getComentario(), entity.getComentario());
    }

}