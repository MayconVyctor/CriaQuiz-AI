package com.criaquiz.infrastructure.adapters.in.web;

import com.criaquiz.application.ports.in.GerarQuizUseCase;
import com.criaquiz.domain.entities.Quiz;
import com.criaquiz.infrastructure.adapters.in.web.dto.CriaQuizRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final GerarQuizUseCase gerarQuizUseCase;

    public QuizController(GerarQuizUseCase gerarQuizUseCase) {
        this.gerarQuizUseCase = gerarQuizUseCase;
    }

    @PostMapping 
    public ResponseEntity<Quiz> criaQuiz(@RequestBody CriaQuizRequest request) {
        Quiz quiz = gerarQuizUseCase.gerarQuiz(
            request.getTema(), 
            request.getTexto(), 
            request.getQuantidadePerguntas()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(quiz);
    }
}
