package com.criaquiz.backend.repository;

import com.criaquiz.backend.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
    List<Pergunta> findByQuizId(Long quizId);
    
}
