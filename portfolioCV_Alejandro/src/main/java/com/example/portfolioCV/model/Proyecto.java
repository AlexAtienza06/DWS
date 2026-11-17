package com.example.portfolioCV.model;

public class Proyecto {
    // Datos que tiene cada proyecto del portfolio.
    private String titulo;
    private int anio;
    private String categoria;
    private String descripcion;
    private String estado;
    private String[] tecnologias;
    private String enlace;
    private String imagen;

    // Constructor para crear un proyecto con todos sus datos.
    public Proyecto(String titulo, int anio, String categoria,
                    String descripcion, String estado,
                    String[] tecnologias, String enlace, String imagen) {
        this.titulo = titulo;
        this.anio = anio;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tecnologias = tecnologias;
        this.enlace = enlace;
        this.imagen = imagen;
    }

    // Métodos para consultar los datos del proyecto.
    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String[] getTecnologias() {
        return tecnologias;
    }

    public String getEnlace() {
        return enlace;
    }

    public String getImagen() {
        return imagen;
    }
}
