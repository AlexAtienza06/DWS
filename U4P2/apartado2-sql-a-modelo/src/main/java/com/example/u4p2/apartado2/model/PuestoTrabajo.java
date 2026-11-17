package com.example.u4p2.apartado2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa los puestos de trabajo que hay en el aula.
 * Guarda información sobre su código, denominación, planta
 * y si tienen electricidad.
 */
@Entity
@Table(name = "puesto_trabajo")
@Getter
@Setter
@NoArgsConstructor
public class PuestoTrabajo {
    @Id
    private int id;

    // El código permite identificar cada puesto y no puede estar repetido.
    @Column(nullable = false, unique = true, length = 10)
    private String codigo_puesto;

    @Column(nullable = false, length = 60)
    private String denominacion;

    // Indica en qué planta del edificio se encuentra el puesto.
    @Column(nullable = false)
    private int planta;

    // Indica si el puesto dispone de conexión eléctrica.
    @Column(nullable = false)
    private boolean tiene_electricidad;
}