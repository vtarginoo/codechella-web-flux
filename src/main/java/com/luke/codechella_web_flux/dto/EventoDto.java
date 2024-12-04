package com.luke.codechella_web_flux.dto;

import com.luke.codechella_web_flux.model.Evento;
import com.luke.codechella_web_flux.model.TipoEvento;

import java.time.LocalDate;

public record EventoDto(
        Long id,
        TipoEvento tipo,
        String nome,
        LocalDate data,
        String descricao
) {
    public static EventoDto toDto(Evento evento) {
        return new EventoDto(evento.getId(), evento.getTipo(), evento.getNome(),
                evento.getData(), evento.getDescricao());
    }
}
