package com.luke.codechella_web_flux.controller;

import com.luke.codechella_web_flux.dto.EventoDto;
import com.luke.codechella_web_flux.model.Evento;
import com.luke.codechella_web_flux.repository.EventoRepository;
import com.luke.codechella_web_flux.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterTodos() {

        return eventoService.obterTodos();
    }
}