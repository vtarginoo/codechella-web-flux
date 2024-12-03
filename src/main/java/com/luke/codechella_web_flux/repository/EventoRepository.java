package com.luke.codechella_web_flux.repository;

import com.luke.codechella_web_flux.model.Evento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventoRepository extends ReactiveCrudRepository<Evento,Long> {
}
