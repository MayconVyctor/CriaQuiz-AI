package com.criaquiz.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pontuacao;

    @Column(name = "total_perguntas")
    private Integer totalPerguntas;

    @Column(name = "respondido_em")
    private LocalDateTime respondidoEm;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @PrePersist
    public void prePersist() {
        this.respondidoEm = LocalDateTime.now();
    }
}