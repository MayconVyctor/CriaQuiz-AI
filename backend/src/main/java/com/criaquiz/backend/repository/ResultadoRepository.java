package com.criaquiz.backend.repository;

import com.criaquiz.backend.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
    List<Resultado> findByUsuarioIdOrderByRespondidoEmDesc(Long usuarioId);
}
