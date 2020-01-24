package com.example.desafio_v2.domain.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafio_v2.domain.dto.request.EventoUpdate;

/**
 * preciso criar uma lógica para impedir que o usuario cancele no dia do evento
 * CancelarValidator
 */


public class CancelarValidator implements ConstraintValidator<CancelarEvento, EventoUpdate> {

    @Override
    public boolean isValid(EventoUpdate value, ConstraintValidatorContext context) {
       
         Calendar dataEvento = Calendar.getInstance();

         dataEvento.setTime(value.getDataHoraFim());
        
         Calendar dataHoje = Calendar.getInstance();

         if (dataHoje.get(Calendar.DAY_OF_MONTH) <= dataEvento.get(Calendar.DAY_OF_MONTH)) return false; 
        // //if (dataHoje.get(Calendar.DAY_OF_MONTH) != dataEvento.get(Calendar.DAY_OF_MONTH)) return false;
        
        
        
        // /* if (value == null) {
        //     return false;
        // } */
        return true;
    }
}