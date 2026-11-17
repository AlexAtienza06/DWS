package com.example.portfolioCV.model;

public class Idioma {
    // Nombre del idioma y nivel que tengo.
    private String nombre;
    private String nivel;

    // Constructor para guardar el idioma y su nivel.
    public Idioma(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    // Métodos para obtener los datos del idioma.
    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }
}