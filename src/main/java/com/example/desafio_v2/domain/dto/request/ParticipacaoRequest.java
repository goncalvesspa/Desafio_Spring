package com.example.desafio_v2.domain.dto.request;


import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParticipacaoRequest{

    
    


//@NotEmpty(message = "IdEvento is required")
    private Integer IdEvento;

    @NotEmpty(message = "LoginParticipante is required")
    private String LoginParticipante;


    //@NotEmpty(message = "FlagPresente is required")
    private boolean FlagPresente;

    //@NotEmpty(message = "Nota is required")
    private Integer Nota;

    @NotEmpty(message = "Comentario is required")
    private String Comentario;





}