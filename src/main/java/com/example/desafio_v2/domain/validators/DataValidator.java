package com.example.desafio_v2.domain.validators;


import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafio_v2.domain.dto.request.EventoRequest;

public class DataValidator implements ConstraintValidator<DataEvento, EventoRequest> {

    @Override
    public boolean isValid(EventoRequest value, ConstraintValidatorContext context) {
       
        Long timeInicio = value.getDataHoraInicio().getTime();
        Long timeFim = value.getDataHoraFim().getTime();

        long validadorMesmoDia = timeFim - timeInicio;

        if(validadorMesmoDia <= 0) return false;
        if(timeInicio < new Date().getTime() + 86400000) return false;

        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();

        inicio.setTime(value.getDataHoraInicio());
        fim.setTime(value.getDataHoraFim());

        if(inicio.get(Calendar.DAY_OF_MONTH) != fim.get(Calendar.DAY_OF_MONTH)) return false;
        if(inicio.get(Calendar.MONTH) != fim.get(Calendar.MONTH)) return false;
        if(inicio.get(Calendar.YEAR) != fim.get(Calendar.YEAR)) return false;


        return true;
       
       
       
    }

}