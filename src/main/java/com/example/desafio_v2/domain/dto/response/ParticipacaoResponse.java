package com.example.desafio_v2.domain.dto.response;


import com.example.desafio_v2.domain.entities.Evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParticipacaoResponse{

    
    private Integer IdParticipacao;


    
    private Evento IdEvento;

    
    private String LoginParticipante;


    
    private boolean FlagPresente;

    
    private Integer Nota;

   
    private String Comentario;





}