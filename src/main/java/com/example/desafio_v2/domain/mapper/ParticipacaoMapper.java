package com.example.desafio_v2.domain.mapper;



import com.example.desafio_v2.domain.dto.request.ParticipacaoRequest;
import com.example.desafio_v2.domain.dto.response.ParticipacaoResponse;
import com.example.desafio_v2.domain.entities.Evento;
import com.example.desafio_v2.domain.entities.Participacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ParticipacaoMapper {

    private final ModelMapper mapper;

    @Autowired
    public ParticipacaoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ParticipacaoResponse toDto(Participacao input) {
        return mapper.map(input, ParticipacaoResponse.class);
    }

    public Participacao fromDto(ParticipacaoRequest input) {

        Participacao model1 = mapper.map(input, Participacao.class);
        Evento evento = new Evento();
        evento.setIdEvento(input.getIdEvento());

        model1.setIdEvento(evento);

        return model1;
        //return mapper.map(input, Participacao.class);
    }

    

    /* public Participacao DELETE(ParticipacaoRequest input) {
        return mapper.map(input, Participacao.class);
    }
 */


}
