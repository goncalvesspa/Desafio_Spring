package com.example.desafio_v2.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StatusEvento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEventoStatus;

    @Column(nullable = false, length = 250)
    private String NomeStatus;
}