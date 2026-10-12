package com.criaquiz.application.ports.in;

import com.criaquiz.domain.entities.Quiz;

public interface GerarQuizUseCase {
    Quiz gerarQuiz(String tema, String texto, int quantidadePerguntas);
}
