package com.criaquiz.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perguntas")
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String enunciado;

    @Column(name = "alternativa_a", columnDefinition = "TEXT")
    private String alternativaA;

    @Column(name = "alternativa_b", columnDefinition = "TEXT")
    private String alternativaB;

    @Column(name = "alternativa_c", columnDefinition = "TEXT")
    private String alternativaC;

    @Column(name = "alternativa_d", columnDefinition = "TEXT")
    private String alternativaD;

    @Column(name = "resposta_correta")
    private String respostaCorreta;   

    @Column(columnDefinition = "TEXT")
    private String explicacao;        


    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;
}