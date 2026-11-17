package com.example.u4p2.apartado1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Representa un recurso disponible en la aplicación.
 * Guarda su información básica, su coste de reposición
 * y si puede prestarse a los usuarios.
 */
@Entity
@Table(name = "recurso")
@Getter
@Setter
@NoArgsConstructor
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Código único para identificar cada recurso.
    @Column(nullable = false, unique = true, length = 12)
    private String codigo;

    @Column(nullable = false, length = 80)
    private String nombre;

    // La descripción es opcional porque no todos los recursos necesitan detalles adicionales.
    @Column(nullable = true, length = 250)
    private String descripcion;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal coste_reposicion;

    // Indica si el recurso está disponible para realizar préstamos.
    @Column(nullable = false)
    private boolean prestable;
}