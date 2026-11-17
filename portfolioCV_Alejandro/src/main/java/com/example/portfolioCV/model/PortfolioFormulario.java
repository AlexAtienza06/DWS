package com.example.portfolioCV.model;

import java.util.ArrayList;
import java.util.List;

public class PortfolioFormulario {
    // Datos personales que se rellenan en el formulario
    private String nombre;
    private String titular;
    private String presentacion;
    private String ciudad;
    private String correo;

    // Lista de proyectos que se pueden añadir o eliminar
    private List<ProyectoFormulario> proyectos;

    public PortfolioFormulario() {
        proyectos = new ArrayList<>();
        // Al entrar al formulario aparece una fila vacía
        proyectos.add(new ProyectoFormulario());
    }

    // Métodos para consultar y modificar los datos personales
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Métodos para consultar y modificar la lista de proyectos
    public List<ProyectoFormulario> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<ProyectoFormulario> proyectos) {
        this.proyectos = proyectos;
    }
}