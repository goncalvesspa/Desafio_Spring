package com.example.desafio_v2.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @JoinColumn(name = "IdEventoStatus", nullable = false)
    @ManyToOne
    private StatusEvento idEventoStatus;

    @JoinColumn(name = "IdCategoriaEvento", nullable = false)
    @ManyToOne
    private CategoriaEvento idCategoriaEvento;

    @Column(nullable = false, length = 250)
    private String nome;

    @Column(nullable = false)
    private Date dataHoraInicio;

    @Column(nullable = false)
    private Date dataHoraFim;

    @Column(nullable = false, length = 250)
    private String local;

    @Column(nullable = false, length = 250)
    private String descricao;

    @Column( name = "LimiteVagas", nullable = false) // Aqui já temos a referencia do banco em maiusculo, por tanto a variavel deve ser minuscula
    private int limiteVagas; // o correto seria declarar variavel em minúsculo

	/* public static Object builder() {
		return null;
	} */



    


    
}