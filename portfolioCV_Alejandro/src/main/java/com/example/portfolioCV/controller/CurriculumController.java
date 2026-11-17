package com.example.portfolioCV.controller;

import com.example.portfolioCV.model.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class CurriculumController {
    // Recogemos el nombre definido en application.properties.
    @Value("${cv.nombre}")
    private String nombre;
    private final MessageSource messageSource;
    public CurriculumController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    // Buscamos cada texto en el archivo de traducciones según el idioma.
    private String texto(String clave, Locale locale) {
        return messageSource.getMessage(clave, null, locale);
    }
    // Mostramos la página del currículum.
    @GetMapping("/curriculum")
    public String mostrarCurriculum(Model model, Locale locale) {
        // Guardamos los estudios y sus fechas.
        Formacion[] formaciones = {
                new Formacion(
                        texto("cv.formacion.1.titulo", locale),
                        "I.E.S. Velázquez",
                        2026,
                        null
                ),
                new Formacion(
                        texto("cv.formacion.2.titulo", locale),
                        "I.E.S. Profesor Juan Antonio Carrillo Salcedo. Morón de la Frontera",
                        2024,
                        2026
                ),
                new Formacion(
                        texto("cv.formacion.3.titulo", locale),
                        "I.E.S. Profesor Juan Antonio Carrillo Salcedo. Morón de la Frontera",
                        2022,
                        2024
                ),
                new Formacion(
                        texto("cv.formacion.4.titulo", locale),
                        "Colegio La Inmaculada Concepción. Morón de la Frontera",
                        2018,
                        2021
                )
        };
        // Guardamos los trabajos y las prácticas realizadas.
        Experiencia[] experiencias = {
                new Experiencia(
                        texto("cv.experiencia.1.puesto", locale),
                        "Colegio La Inmaculada",
                        "Marzo 2024 - Junio 2024",
                        texto("cv.experiencia.1.descripcion", locale)
                ),
                new Experiencia(
                        texto("cv.experiencia.2.puesto", locale),
                        "Plug Connect SLU",
                        "11 Mayo 2026 - 29 Mayo 2026",
                        texto("cv.experiencia.2.descripcion", locale)
                ),
                new Experiencia(
                        texto("cv.experiencia.3.puesto", locale),
                        texto("cv.experiencia.3.empresa", locale),
                        "Febrero 2023 - Marzo 2023 y Febrero 2024 - Marzo 2024",
                        texto("cv.experiencia.3.descripcion", locale)
                )
        };
        // Indicamos las habilidades y el nivel que tengo en cada una.
        Habilidad[] habilidades = {
                new Habilidad(texto("cv.habilidad.1", locale), "alto"),
                new Habilidad(texto("cv.habilidad.2", locale), "medio"),
                new Habilidad(texto("cv.habilidad.3", locale), "medio"),
                new Habilidad(texto("cv.habilidad.4", locale), "alto"),
                new Habilidad(texto("cv.habilidad.5", locale), "medio"),
                new Habilidad(texto("cv.habilidad.6", locale), "medio")
        };
        // Indicamos los idiomas y sus niveles.
        Idioma[] idiomas = {
                new Idioma(texto("cv.idioma.1", locale), "alto"),
                new Idioma(texto("cv.idioma.2", locale), "bajo"),
                new Idioma(texto("cv.idioma.3", locale), "bajo")
        };
        // Reunimos toda la información para crear el currículum.
        Curriculum curriculum = new Curriculum(
                nombre,
                texto("cv.titular", locale),
                texto("cv.presentacion", locale),
                "alejandroatienzanaranjo@gmail.com",
                "653280467",
                "Morón de la Frontera",
                formaciones,
                experiencias,
                habilidades,
                idiomas
        );
        // Enviamos el currículum a la plantilla HTML.
        model.addAttribute("cv", curriculum);
        return "curriculum";
    }
}