package com.criaquiz.application.ports.in;

public interface GerarQuizUseCase {
    void gerarQuiz(String tema, String texto, int quantidadePerguntas);
}
