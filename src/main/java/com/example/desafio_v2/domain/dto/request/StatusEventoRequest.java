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


public class StatusEventoRequest {
    
    
    @NotEmpty(message = "NomeStatus is required")
    private String NomeStatus;
}