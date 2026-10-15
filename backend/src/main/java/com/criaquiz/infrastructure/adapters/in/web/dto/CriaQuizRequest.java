package com.criaquiz.infrastructure.adapters.in.web.dto;

public class CriaQuizRequest {
    private String tema;
    private String texto;
    private int quantidadePerguntas;

    public CriaQuizRequest() {
    }

    public CriaQuizRequest(String tema, String texto, int quantidadePerguntas) {
        this.tema = tema;
        this.texto = texto;
        this.quantidadePerguntas = quantidadePerguntas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getQuantidadePerguntas() {
        return quantidadePerguntas;
    }

    public void setQuantidadePerguntas(int quantidadePerguntas) {
        this.quantidadePerguntas = quantidadePerguntas;
    }
}
