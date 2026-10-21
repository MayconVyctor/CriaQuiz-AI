package com.criaquiz.application.usecases;

import com.criaquiz.application.ports.in.GerarQuizUseCase;
import com.criaquiz.application.ports.out.AiQuizGeneratePort;
import com.criaquiz.application.ports.out.QuizRepositoryPort;
import com.criaquiz.domain.entities.Pergunta;
import com.criaquiz.domain.entities.Quiz;
import java.util.List;


public class GerarQuizService implements GerarQuizUseCase {

    private final QuizRepositoryPort quizRepository;

    private final AiQuizGeneratePort aiQuizGeneratePort;

    public GerarQuizService(QuizRepositoryPort quizRepository, AiQuizGeneratePort aiQuizGeneratePort) {
        this.quizRepository = quizRepository;
        this.aiQuizGeneratePort = aiQuizGeneratePort;
    }

   @Override
    public Quiz gerarQuiz(String tema, String texto, int quantidadePerguntas) {
        
        List<Pergunta> perguntas = aiQuizGeneratePort.gerarPerguntas(tema, texto, quantidadePerguntas);
        Quiz novoQuiz = new Quiz(null, "Quiz sobre " + tema, tema, perguntas);
        
        return quizRepository.save(novoQuiz);
    }
}