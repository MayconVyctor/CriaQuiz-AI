package com.criaquiz.infrastructure.adapters.out.persistence;

import com.criaquiz.application.ports.out.QuizRepositoryPort;
import com.criaquiz.domain.entities.Pergunta;
import com.criaquiz.domain.entities.Quiz;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class QuizPersistenceAdapter implements QuizRepositoryPort {

    private final SpringDataQuizRepository repository;
    public QuizPersistenceAdapter(SpringDataQuizRepository repository) {
        this.repository = repository;
    }
    @Override
    public Quiz save(Quiz quiz) {
        QuizJpaEntity jpaEntity = new QuizJpaEntity(quiz.getId(), quiz.getTitulo(), quiz.getTema());
        QuizJpaEntity entitySalva = repository.save(jpaEntity);
        return new Quiz(
            entitySalva.getId(),
            entitySalva.getTitulo(),
            entitySalva.getTema(),
            quiz.getPerguntas() != null ? quiz.getPerguntas() : new ArrayList<Pergunta>()
        );
    }
    @Override
    public Quiz findById(Long id) {
        return repository.findById(id)
            .map(entity -> new Quiz(
                entity.getId(), 
                entity.getTitulo(), 
                entity.getTema(), 
                new ArrayList<Pergunta>()
            ))
            .orElse(null);
    }
    
}
