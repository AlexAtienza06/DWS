package com.example.portfolioCV.model;

public class Experiencia {
    // Datos de cada experiencia laboral.
    private String puesto;
    private String empresa;
    private String periodo;
    private String descripcion;

    // Constructor para guardar la información de una experiencia.
    public Experiencia(String puesto, String empresa, String periodo, String descripcion) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.periodo = periodo;
        this.descripcion = descripcion;
    }

    // Métodos para obtener los datos de la experiencia.
    public String getPuesto() {
        return puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}