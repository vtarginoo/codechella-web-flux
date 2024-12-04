package com.luke.codechella_web_flux.controller;

import com.luke.codechella_web_flux.dto.EventoDto;
import com.luke.codechella_web_flux.model.Evento;
import com.luke.codechella_web_flux.repository.EventoRepository;
import com.luke.codechella_web_flux.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

@RestController
@RequestMapping("/eventos")
public class EventoController {


    private final EventoService eventoService;

    private final Sinks.Many<EventoDto> eventoSink;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
        this.eventoSink = Sinks.many().multicast().onBackpressureBuffer();
    }


    @GetMapping
    public Flux<EventoDto> obterTodos() {

        return eventoService.obterTodos();
    }


    @GetMapping("/{id}")
    public Mono<EventoDto> obterPorId(@PathVariable Long id) {

        return eventoService.obterporId(id);
    }

    @GetMapping(value = "categoria/{tipo}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterPorTipo(@PathVariable String tipo){

        return Flux.merge(eventoService.obterPorTipo(tipo), eventoSink.asFlux()).delayElements(Duration.ofSeconds(4));
    }

    @PostMapping
    public Mono<EventoDto> cadastrar(@RequestBody EventoDto dto) {

        return  eventoService.cadastrar(dto).doOnSuccess(eventoSink::tryEmitNext);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> excluir (@PathVariable Long id) {

        return eventoService.excluir(id);
    }

    @PutMapping("/{id}")
    public Mono<EventoDto> alterar (@PathVariable Long id,
                               @RequestBody EventoDto dto) {

        return eventoService.alterar(id,dto);
    }







    }