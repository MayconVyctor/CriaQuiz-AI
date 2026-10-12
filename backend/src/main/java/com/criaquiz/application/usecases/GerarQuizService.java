package com.criaquiz.application.usecases;

import com.criaquiz.application.ports.in.GerarQuizUseCase;
import com.criaquiz.application.ports.out.QuizRepositoryPort;
import com.criaquiz.domain.entities.Pergunta;
import com.criaquiz.domain.entities.Quiz;
import java.util.ArrayList;

public class GerarQuizService implements GerarQuizUseCase {

    private final QuizRepositoryPort quizRepository;

    public GerarQuizService(QuizRepositoryPort quizRepository) {
        this.quizRepository = quizRepository;
    }

   @Override
    public Quiz gerarQuiz(String tema, String texto, int quantidadePerguntas) {
        Quiz novoQuiz = new Quiz(null, "Quiz sobre " + tema, tema, 
            new ArrayList<Pergunta>());
        
        return quizRepository.save(novoQuiz);
    }
}