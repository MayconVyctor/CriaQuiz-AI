package com.criaquiz.infrastructure.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataQuizRepository extends JpaRepository<QuizJpaEntity, Long> {
    
}
