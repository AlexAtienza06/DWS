package com.example.portfolioCV.model;

public class Curriculum {
    // Datos personales del currículum.
    private String nombre;
    private String titular;
    private String presentacion;
    private String correo;
    private String telefono;
    private String ciudad;

    // Arrays con la información de cada apartado.
    private Formacion[] formaciones;
    private Experiencia[] experiencias;
    private Habilidad[] habilidades;
    private Idioma[] idiomas;

    // Constructor para guardar toda la información del currículum.
    public Curriculum(String nombre, String titular, String presentacion,
                      String correo, String telefono, String ciudad,
                      Formacion[] formaciones, Experiencia[] experiencias,
                      Habilidad[] habilidades, Idioma[] idiomas) {

        this.nombre = nombre;
        this.titular = titular;
        this.presentacion = presentacion;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.formaciones = formaciones;
        this.experiencias = experiencias;
        this.habilidades = habilidades;
        this.idiomas = idiomas;
    }

    // Métodos para obtener los datos del currículum.
    public String getNombre() {
        return nombre;
    }

    public String getTitular() {
        return titular;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Formacion[] getFormaciones() {
        return formaciones;
    }

    public Experiencia[] getExperiencias() {
        return experiencias;
    }

    public Habilidad[] getHabilidades() {
        return habilidades;
    }

    public Idioma[] getIdiomas() {
        return idiomas;
    }
}