package com.example.grupoJovenU4P3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

// Esta clase representa una actividad y permite guardarla en la base de datos.
@Entity
@Table(name = "actividades")
@Getter
@Setter
@NoArgsConstructor
public class Actividad {
    @Id
    // El identificador se genera automáticamente al guardar una actividad.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    // La descripción es opcional, por eso no tiene la validación NotBlank.
    @Size(max = 400, message = "La descripción no puede superar los 400 caracteres")
    @Column(length = 400)
    private String descripcion;

    @NotBlank(message = "El tipo es obligatorio")
    @Size(max = 50, message = "El tipo no puede superar los 50 caracteres")
    @Column(nullable = false, length = 50)
    private String tipo;

    @NotNull(message = "La fecha es obligatoria")
    @Column(nullable = false)
    private LocalDate fecha;

    @NotNull(message = "La hora es obligatoria")
    @Column(nullable = false)
    private LocalTime hora;

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 15, message = "La duración mínima es de 15 minutos")
    @Max(value = 840, message = "La duración máxima es de 840 minutos")
    @Column(nullable = false)
    private Integer duracionMinutos;

    @Min(value = 0, message = "La asistencia no puede ser negativa")
    private Integer asistencia;

    @NotNull(message = "El coste es obligatorio")
    @DecimalMin(value = "0.00", message = "El coste no puede ser negativo")
    @DecimalMax(value = "999.99", message = "El coste máximo es 999,99")
    @Digits(integer = 3, fraction = 2, message = "El coste debe tener como máximo dos decimales")
    // BigDecimal permite guardar importes con decimales de forma más precisa.
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal coste;

    @NotNull(message = "Debes indicar si requiere inscripción")
    @Column(nullable = false)
    private Boolean requiereInscripcion;

    @NotBlank(message = "El lugar es obligatorio")
    @Size(max = 100, message = "El lugar no puede superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String lugar;
}