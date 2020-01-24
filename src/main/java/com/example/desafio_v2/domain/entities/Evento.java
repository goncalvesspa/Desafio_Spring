package com.example.desafio_v2.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Evento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEvento;

    @JoinColumn(name = "IdEventoStatus", nullable = false)
    @ManyToOne
    private StatusEvento IdEventoStatus;

    @JoinColumn(name = "IdCategoriaEvento", nullable = false)
    @ManyToOne
    private CategoriaEvento IdCategoriaEvento;

    @Column(nullable = false, length = 250)
    private String Nome;

    @Column(nullable = false)
    private Date DataHoraInicio;

    @Column(nullable = false)
    private Date DataHoraFim;

    @Column(nullable = false, length = 250)
    private String local;

    @Column(nullable = false, length = 250)
    private String Descricao;

    @Column( name = "LimiteVagas", nullable = false) // Aqui já temos a referencia do banco em maiusculo, por tanto a variavel deve ser minuscula
    private int LimiteVagas; // o correto seria declarar variavel em minúsculo



    


    
}