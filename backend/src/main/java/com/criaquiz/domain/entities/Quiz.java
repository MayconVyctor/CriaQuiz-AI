package com.criaquiz.domain.entities;

import java.util.List;

public class Quiz {

    private long id;

    private String texto;

    private String tema;

    private List<Pergunta> perguntas;

    public Quiz() {

    }

    public Quiz(Long id, String texto, String tema, List<Pergunta> perguntas) {
        this.id = id;
        this.texto = texto;
        this.tema = tema;
        this.perguntas = perguntas;
    }

    public long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public String getTema() {
        return tema;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
}