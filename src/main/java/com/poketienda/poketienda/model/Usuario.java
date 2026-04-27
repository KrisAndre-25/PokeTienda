package com.poketienda.poketienda.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Importación necesaria para el hotfix
import com.fasterxml.jackson.annotation.JsonProperty; [cite: 5]

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario { [cite: 5]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; [cite: 5]

    private String username; [cite: 6]
    private String email; [cite: 6]

    // Hotfix: Se permite escribir la contraseña al crear/editar, 
    // pero se oculta al listar o consultar usuarios por API.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password; [cite: 6]

    private LocalDateTime fecha_creacion; [cite: 6]
    private Boolean activo = true; [cite: 6]
}