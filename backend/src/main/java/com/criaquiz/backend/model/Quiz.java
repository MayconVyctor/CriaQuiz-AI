package com.criaquiz.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String tema;

    @Column(name = "quantidade_perguntas")
    private Integer quantidadePerguntas;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "material_id", nullable = true)
    private Material material;


    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Resultado> resultados;

    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }
}