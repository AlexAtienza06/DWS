package com.example.portfolioCV.model;

public class Formacion {
    // Datos de cada formación académica.
    private String titulo;
    private String centro;
    private int fechaInicio;
    private Integer fechaFin;

    // Constructor para guardar los datos de los estudios.
    public Formacion(String titulo, String centro, int fechaInicio, Integer fechaFin) {
        this.titulo = titulo;
        this.centro = centro;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Métodos para obtener los datos de la formación.
    public String getTitulo() {
        return titulo;
    }

    public String getCentro() {
        return centro;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public Integer getFechaFin() {
        return fechaFin;
    }
}