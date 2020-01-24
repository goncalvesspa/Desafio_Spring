package com.example.desafio_v2.domain.dto.response;

import java.util.Date;

import com.example.desafio_v2.domain.entities.CategoriaEvento;
import com.example.desafio_v2.domain.entities.StatusEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventoResponse{
   
    private Integer IdEvento;

   
    private StatusEvento IdEventoStatus;

    
    private CategoriaEvento IdCategoriaEvento;

    
    private String Nome;

    
    private Date DataHoraInicio;

    
    private Date DataHoraFim;

    
    private String local;

    
    private String Descricao;

    
    private Integer LimiteVagas;



    


    
}