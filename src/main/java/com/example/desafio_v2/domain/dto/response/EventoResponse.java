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
   
    private Integer idEvento;

   
    private StatusEvento idEventoStatus;

    
    private CategoriaEvento idCategoriaEvento;

    
    private String nome;

    
    private Date dataHoraInicio;

    
    private Date dataHoraFim;

    
    private String local;

    
    private String descricao;

    
    private Integer limiteVagas;



    


    
}