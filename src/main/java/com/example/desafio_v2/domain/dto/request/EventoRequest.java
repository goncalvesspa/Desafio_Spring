package com.example.desafio_v2.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.desafio_v2.domain.validators.DataEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DataEvento
//@CancelarEvento
public class EventoRequest{

    
    

    
    private Integer idCategoriaEvento;

    @NotEmpty(message = "name is required")
    private String nome;

    @NotNull
    private Date dataHoraInicio;

    @NotNull
    private Date dataHoraFim;

    @NotEmpty(message = "local is required")
    private String local;

    @NotEmpty(message = "Descricao is required")
    private String descricao;

    
    private Integer limiteVagas;



    


    
}