package com.criaquiz.backend.repository;

import com.criaquiz.backend.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByUsuarioIdOrderByCriadoEmDesc(Long usuarioId);
}
