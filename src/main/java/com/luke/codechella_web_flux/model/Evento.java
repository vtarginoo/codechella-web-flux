package com.luke.codechella_web_flux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("eventos")
public class Evento {

    @Id
    private Long id;

    private TipoEvento tipo;
    private String nome;
    private LocalDate data;
    private String descricao;

    public Long getId() {
        return id;
    }
}