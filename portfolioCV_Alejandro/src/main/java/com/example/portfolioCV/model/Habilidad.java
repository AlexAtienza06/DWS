package com.example.portfolioCV.model;

public class Habilidad {
    // Nombre de la habilidad y nivel que tengo.
    private String nombre;
    private String nivel;

    // Constructor para guardar la habilidad y su nivel.
    public Habilidad(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    // Métodos para obtener los datos de la habilidad.
    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }
}