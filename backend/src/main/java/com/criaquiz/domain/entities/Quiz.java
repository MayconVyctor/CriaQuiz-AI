package com.criaquiz.domain.entities;

import java.util.List;

public class Quiz {

    private Long id;

    private String titulo;

    private String tema;

    private List<Pergunta> perguntas;

    public Quiz() {

    }

    public Quiz(Long id, String titulo, String tema, List<Pergunta> perguntas) {
        this.id = id;
        this.titulo = titulo;
        this.tema = tema;
        this.perguntas = perguntas;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
}