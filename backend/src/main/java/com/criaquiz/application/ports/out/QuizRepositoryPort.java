package com.criaquiz.application.ports.out;

import com.criaquiz.domain.entities.Quiz;

public interface QuizRepositoryPort {
    Quiz save(Quiz quiz);

    Quiz findById(Long id);
}
