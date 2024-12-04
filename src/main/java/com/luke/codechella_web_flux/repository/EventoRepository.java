package com.luke.codechella_web_flux.repository;

import com.luke.codechella_web_flux.model.Evento;
import com.luke.codechella_web_flux.model.TipoEvento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface EventoRepository extends ReactiveCrudRepository<Evento,Long> {


    Flux<Evento> findByTipo(TipoEvento tipoEvento);
}
