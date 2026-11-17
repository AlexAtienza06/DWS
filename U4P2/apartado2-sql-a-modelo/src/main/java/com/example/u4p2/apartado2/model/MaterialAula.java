package com.example.u4p2.apartado2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Representa los materiales que hay disponibles en el aula.
 * Guarda sus datos, como la referencia, el nombre, la descripción,
 * el coste de reposición y las unidades disponibles.
 */
@Entity
@Table(name = "material_aula")
@Getter
@Setter
@NoArgsConstructor
public class MaterialAula {
    @Id
    private int id;

    // La referencia sirve para identificar cada material y no puede repetirse.
    @Column(nullable = false, unique = true, length = 12)
    private String referencia;

    private String nombre_material;

    @Column(nullable = false, length = 250)
    private String descripcion;

    // Uso BigDecimal para guardar el coste con decimales y evitar errores de precisión.
    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal coste_reposicion;

    // Indica cuántas unidades de ese material hay disponibles.
    @Column(nullable = false)
    private short unidades;
}