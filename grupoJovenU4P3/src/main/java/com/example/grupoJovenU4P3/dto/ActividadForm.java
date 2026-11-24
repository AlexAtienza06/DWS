package com.example.grupoJovenU4P3.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

// Esta clase recoge los datos del formulario antes de pasarlos a la entidad Actividad.
@Getter
@Setter
@NoArgsConstructor
public class ActividadForm {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    // La descripción puede dejarse vacía porque es un campo opcional.
    @Size(max = 400, message = "La descripción no puede superar los 400 caracteres")
    private String descripcion;

    @NotBlank(message = "El tipo es obligatorio")
    @Size(max = 50, message = "El tipo no puede superar los 50 caracteres")
    private String tipo;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "La hora es obligatoria")
    private LocalTime hora;

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 15, message = "La duración mínima es de 15 minutos")
    @Max(value = 840, message = "La duración máxima es de 840 minutos")
    private Integer duracionMinutos;

    // La asistencia es opcional, pero si se indica no puede ser negativa.
    @Min(value = 0, message = "La asistencia no puede ser negativa")
    private Integer asistencia;

    @NotNull(message = "El coste es obligatorio")
    @DecimalMin(value = "0.00", message = "El coste no puede ser negativo")
    @DecimalMax(value = "999.99", message = "El coste máximo es 999,99")
    @Digits(integer = 3, fraction = 2, message = "El coste debe tener como máximo dos decimales")
    private BigDecimal coste;

    @NotNull(message = "Debes indicar si requiere inscripción")
    private Boolean requiereInscripcion;

    @NotBlank(message = "El lugar es obligatorio")
    @Size(max = 100, message = "El lugar no puede superar los 100 caracteres")
    private String lugar;
}