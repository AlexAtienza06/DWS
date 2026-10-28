package com.example.p5p6SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
    /**
     * Guardamos las actividades que vamos a mostrar en la web en un array.
     * Cada fila contiene título, descripción y dato práctico.
     **/
    private String[][] actividades = {
            {"actividad.banda.titulo", "actividad.banda.descripcion", "actividad.banda.dato"},
            {"actividad.sanmiguel.titulo", "actividad.sanmiguel.descripcion", "actividad.sanmiguel.dato"},
            {"actividad.santaclara.titulo", "actividad.santaclara.descripcion", "actividad.santaclara.dato"}
    };

    // Cuando entramos en la página principal, enviamos las actividades a la vista.
    @GetMapping("/")
    public String inicio(Model model) {
        // Guardamos el array en el modelo para poder recorrerlo desde Thymeleaf.
        model.addAttribute("actividades", actividades);

        // Devolvemos la plantilla inicio.html.
        return "inicio";
    }

    // Esta ruta muestra la información para organizar una visita al centro.
    @GetMapping("/visita")
    public String visita() {
        // Devolvemos la plantilla visita.html.
        return "visita";
    }
}