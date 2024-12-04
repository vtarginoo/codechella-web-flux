package com.luke.codechella_web_flux.service;

import com.luke.codechella_web_flux.dto.EventoDto;
import com.luke.codechella_web_flux.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repositorio;


    public Flux<EventoDto> obterTodos (){

        return repositorio.findAll().map(EventoDto::toDto);
    }


}
