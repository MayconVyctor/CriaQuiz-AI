package com.criaquiz.application.ports.out;

import java.util.List;

import com.criaquiz.domain.entities.Pergunta;

public interface AiQuizGeneratePort {
    List<Pergunta> gerarPerguntas(String tema, String texto, int quantidadePerguntas);
}
