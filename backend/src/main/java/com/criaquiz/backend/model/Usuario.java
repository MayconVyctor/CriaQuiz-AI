package com.criaquiz.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String senha;

    @Column(name = "created_em")
    private LocalDateTime criadoEm;

   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Material> materiais;

   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

   @PrePersist  
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }

}