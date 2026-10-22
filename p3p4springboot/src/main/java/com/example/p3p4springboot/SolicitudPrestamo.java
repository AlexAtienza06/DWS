package com.example.p3p4springboot;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.*;

// DTO que guarda y valida los datos del formulario de préstamo.
public class SolicitudPrestamo {

    // El nombre es obligatorio y no puede superar los 60 caracteres.
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 60, message = "El nombre no puede superar los 60 caracteres.")
    private String nombre;

    // Comprueba que el correo tenga un formato válido.
    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "Introduce un correo electrónico válido.")
    @Size(max = 120, message = "El correo no puede superar los 120 caracteres.")
    private String correo;

    // El usuario debe seleccionar un material del catálogo.
    @NotBlank(message = "Debes seleccionar un material.")
    private String material;

    // Las unidades son obligatorias y deben estar entre 1 y 3.
    @NotNull(message = "Debes indicar el número de unidades.")
    @Min(value = 1, message = "Debes solicitar al menos 1 unidad.")
    @Max(value = 3, message = "No puedes solicitar más de 3 unidades.")
    private Integer unidades;

    // La fecha debe ser hoy o un día posterior.
    @NotNull(message = "Debes indicar la fecha de recogida.")
    @FutureOrPresent(message = "La recogida no puede ser anterior a hoy.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRecogida;

    // La fecha debe ser hoy o un día posterior.
    // Más adelante comprobaremos que no sea anterior a la recogida.
    @NotNull(message = "Debes indicar la fecha de devolución.")
    @FutureOrPresent(message = "La devolución no puede ser anterior a hoy.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDevolucion;

    // El motivo es obligatorio y debe tener entre 30 y 400 caracteres.
    @NotBlank(message = "Debes explicar el motivo del préstamo.")
    @Size(min = 30, max = 400,
            message = "El motivo debe tener entre 30 y 400 caracteres.")
    private String motivo;

    private boolean aceptaNormas;

    // Comprueba que el usuario haya marcado la casilla de aceptación.
    @AssertTrue(message = "Debes aceptar las normas del préstamo.")
    public boolean isAceptaNormas() {
        return aceptaNormas;
    }

    public void setAceptaNormas(boolean aceptaNormas) {
        this.aceptaNormas = aceptaNormas;
    }

    // Getters y setters para que Spring pueda consultar y guardar los datos.

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public LocalDate getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(LocalDate fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
