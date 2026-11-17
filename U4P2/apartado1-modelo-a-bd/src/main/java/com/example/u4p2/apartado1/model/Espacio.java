package com.example.u4p2.apartado1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un espacio físico de la aplicación.
 * Almacena sus datos principales, como el nombre, el aforo,
 * la planta en la que se encuentra y si es accesible.
 */
@Entity
@Table(name = "espacio")
@Getter
@Setter
@NoArgsConstructor
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El código identifica cada espacio y no puede repetirse.
    @Column(nullable = false, unique = true, length = 8)
    private String codigo_espacio;

    @Column(nullable = false, length = 60)
    private String nombre_espacio;

    @Column(nullable = false)
    private int aforo;

    @Column(nullable = false)
    private int planta;

    // Indica si el espacio está adaptado para personas con movilidad reducida.
    @Column(nullable = false)
    private boolean accesible;
}