package com.example.desafio_v2.service;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.desafio_v2.exception.DataNotFoundException;
import com.example.desafio_v2.domain.entities.Evento;
//import com.example.desafio_v2.domain.entities.StatusEvento;
import com.example.desafio_v2.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final StatusEventoService statusEventoService;

    @Autowired
    public EventoService(EventoRepository eventoRepository, StatusEventoService statusEventoService) {
        this.eventoRepository = eventoRepository;
        this.statusEventoService = statusEventoService;
    }

//n fazer nos satatus
public Evento createEvento(Evento model) {
    return eventoRepository.save(model);
}


public List<Evento> listEvento() {
    return eventoRepository.findAll();
}

public Evento findById(Integer id) {
    Optional<Evento> evento = eventoRepository.findById(id);
    return evento.orElseThrow(() -> new DataNotFoundException("Evento Not found"));
}


//n fazer nos satatus
/*  public void deleteEvento(Integer id) {
    eventoRepository.deleteById(id); */
     //listClient();
    
 
//n fazer nos satatus
public Evento updateEvento(Integer id, Evento newEvento) {
    Evento evento = findById(id);

    evento.setNome(newEvento.getNome());
    //evento.setlocal(newEvento.getlocal());

   return eventoRepository.save(evento);
   
} 

public  List<String> listDistinct() {
    return eventoRepository.listDistinct();

}


/* public Evento iniciarEvento(Integer id, 2){
    
    return 

} */

public Evento cancelar(Integer id){
    Evento idd = findById(id);

    Calendar diaEvento = Calendar.getInstance();
    Calendar deletarEvento = Calendar.getInstance();

    diaEvento.setTime(idd.getDataHoraInicio());
    deletarEvento.setTime(new Date());

    if (validaData (diaEvento, deletarEvento)){
        throw new DataNotFoundException("Não é possível cancelar o Evento hoje!");
    }
    idd.setIdEventoStatus(statusEventoService.findById(4));
    return eventoRepository.save(idd);


}
    



public Evento iniciar(Integer id){
    Evento ini = findById(id);

    Calendar iniE = Calendar.getInstance();
    Calendar iniD = Calendar.getInstance();

    iniE.setTime(ini.getDataHoraInicio());
    iniD.setTime(new Date());

    if(!validaData(iniE, iniD)){
        throw new DataNotFoundException("Não é possivel iniciar o evento.");
    }
    ini.setIdEventoStatus(statusEventoService.findById(2));
    return eventoRepository.save(ini);
}

public List<Evento> listEventoUsuario() {
    return eventoRepository.findAll();
}


public boolean validaData(Calendar ini, Calendar dia){
    if((ini.get(Calendar.DAY_OF_YEAR) == dia.get(Calendar.DAY_OF_YEAR)) && (ini.get(Calendar.YEAR) == dia.get(Calendar.YEAR))){
        return true;
    }
    return false;
}

}

/* public Evento cancelar(Integer id){
        Evento e = findById(id);
 
        Calendar diaEvento = Calendar.getInstance();
        Calendar deletarEvento = Calendar.getInstance();
 
        diaEvento.setTime(e.getDataHoraInicio());
        deletarEvento.setTime(new Date());
 
        if(validaData(diaEvento, deletarEvento)){
            throw new DataNotFoundException("Não é possivel cancelar o Evento no dia de inicio.");
        }
        e.setEventoStatus(statusEventoService.findById(4));
        return eventoRepository.save(e);
    }
 
    public Evento iniciar(Integer id){
        Evento ini = findById(id);
 
        Calendar iniE = Calendar.getInstance();
        Calendar iniD = Calendar.getInstance();
 
        iniE.setTime(ini.getDataHoraInicio());
        iniD.setTime(new Date());
 
        if(!validaData(iniE, iniD)){
            throw new DataNotFoundException("Não é possivel iniciar o evento.");
        }
        ini.setEventoStatus(statusEventoService.findById(2));
        return eventoRepository.save(ini);
    }
 
    public List<Evento> listEventoUsuario() {
        return eventoRepository.findAll();
    }
 
    public boolean validaData(Calendar ini, Calendar dia){
        if((ini.get(Calendar.DAY_OF_YEAR) == dia.get(Calendar.DAY_OF_YEAR)) && (ini.get(Calendar.YEAR) == dia.get(Calendar.YEAR))){
            return true;
        }
        return false;
    }*/