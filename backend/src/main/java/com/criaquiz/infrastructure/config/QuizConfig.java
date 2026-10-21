package com.criaquiz.infrastructure.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.criaquiz.application.ports.in.GerarQuizUseCase;
import com.criaquiz.application.ports.out.AiQuizGeneratePort;
import com.criaquiz.application.ports.out.QuizRepositoryPort;
import com.criaquiz.application.usecases.GerarQuizService;


@Configuration 
public class QuizConfig {

    @Bean
    public GerarQuizUseCase gerarQuizUseCase(QuizRepositoryPort quizRepository, AiQuizGeneratePort aiQuizGeneratePort) {
        return new GerarQuizService(quizRepository, aiQuizGeneratePort);
    }

}
