package com.criaquiz.domain.entities;

import java.util.List;

public class Pergunta {
    private String id;

    private String enunciado;

    private List<String> alternativas;

    private String alternativaCorreta;

    private String explicacao;

    public Pergunta() {

    }

    public Pergunta(String id, String enunciado, List<String> alternativas, String alternativaCorreta, String explicacao) {
        this.id = id;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;
        this.explicacao = explicacao;
    }
    
    public boolean isRespostaCorreta(String respostaDada) {
        return this.alternativaCorreta.equalsIgnoreCase(respostaDada);
    }

    public String getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public String getExplicacao() {
        return explicacao;
    }
}