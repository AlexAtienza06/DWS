package com.example.portfolioCV.model;

public class ProyectoFormulario {
    // Datos que se rellenan para cada proyecto
    private String titulo;
    private String anio;
    private String categoria;
    private String estado;
    private String descripcion;

    // Constructor vacío para crear nuevos proyectos
    public ProyectoFormulario() {
    }

    // Métodos para consultar y modificar los datos del proyecto
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}