package com.example.desafio_v2.domain.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Data;
import com.example.desafio_v2.domain.validators.CancelarEvento;

/**
 * EventoUpdate
 */

@Data
@CancelarEvento
public class EventoUpdate extends EventoRequest{

    @NotNull
    private Integer IdEventoStatus;

}