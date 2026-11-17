package com.example.portfolioCV.controller;

import com.example.portfolioCV.model.Proyecto;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Locale;

@Controller
public class PortfolioController {
    private final MessageSource messageSource;

    public PortfolioController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // Buscamos el texto correspondiente al idioma seleccionado.
    private String texto(String clave, Locale locale) {
        return messageSource.getMessage(clave, null, locale);
    }

    // Mostramos el portfolio y recibimos los filtros.
    @GetMapping("/portfolio")
    public String mostrarPortfolio(
            @RequestParam(defaultValue = "") String categoria,
            @RequestParam(defaultValue = "") String anio,
            Model model, Locale locale) {
        // Creamos la lista donde guardamos todos los proyectos.
        ArrayList<Proyecto> proyectos = new ArrayList<>();

        // Proyecto de fichaje de empleados
        proyectos.add(new Proyecto(
                texto("portfolio.proyecto1.titulo", locale),
                2026,
                "Sitios web",
                texto("portfolio.proyecto1.descripcion", locale),
                "Terminado",
                new String[]{"HTML", "CSS", "Java"},
                "",
                ""
        ));

        // Página web creada y mantenida con WordPress
        proyectos.add(new Proyecto(
                texto("portfolio.proyecto2.titulo", locale),
                2023,
                "Sitios web",
                texto("portfolio.proyecto2.descripcion", locale),
                "Terminado",
                new String[]{"WordPress", "HTML", "CSS"},
                "",
                ""
        ));

        // Proyecto de préstamo de material del aula maker
        proyectos.add(new Proyecto(
                texto("portfolio.proyecto3.titulo", locale),
                2026,
                "Aplicaciones",
                texto("portfolio.proyecto3.descripcion", locale),
                "Terminado",
                new String[]{"Java", "Spring Boot", "Thymeleaf"},
                "https://github.com/AlexAtienza06/DWS/tree/main/p3p4springboot",
                ""
        ));

        // Proyecto de plan de estudio
        proyectos.add(new Proyecto(
                texto("portfolio.proyecto4.titulo", locale),
                2026,
                "Sitios web",
                texto("portfolio.proyecto4.descripcion", locale),
                "Terminado",
                new String[]{"Java", "Spring Boot", "Thymeleaf", "HTML", "CSS"},
                "https://github.com/AlexAtienza06/DWS/tree/main/p2springboot",
                ""
        ));
        // Web del Grupo Joven de la Hermandad de Jesús Nazareno
        proyectos.add(new Proyecto(
                texto("portfolio.proyecto5.titulo", locale),
                2026,
                "Aplicaciones",
                texto("portfolio.proyecto5.descripcion", locale),
                "En curso",
                new String[]{},
                "",
                ""
        ));

        Integer anioFiltro = null;
        boolean errorAnio = false;

        // Comprobamos que el año introducido sea un número válido.
        if (!anio.isEmpty()) {
            try {
                anioFiltro = Integer.parseInt(anio);
            } catch (NumberFormatException e) {
                errorAnio = true;
            }
        }
        // Aplicamos los filtros a la lista de proyectos.
        ArrayList<Proyecto> proyectosFiltrados =
                filtrarProyectos(proyectos, categoria, anioFiltro);
        // Enviamos los resultados y los datos de los filtros a la página.
        model.addAttribute("proyectos", proyectosFiltrados);
        model.addAttribute("categoriaSeleccionada", categoria);
        model.addAttribute("anioSeleccionado", anio);
        model.addAttribute("errorAnio", errorAnio);
        model.addAttribute("totalProyectos", proyectosFiltrados.size());

        return "portfolio";
    }

    // Filtramos los proyectos según la categoría y el año seleccionados.
    private ArrayList<Proyecto> filtrarProyectos(
            ArrayList<Proyecto> coleccion,
            String categoria,
            Integer anio) {

        ArrayList<Proyecto> resultado = new ArrayList<>();

        for (Proyecto proyecto : coleccion) {
            // Si no se selecciona categoría o año, no aplicamos ese filtro.
            boolean coincideCategoria = categoria.isEmpty() || proyecto.getCategoria().equals(categoria);
            boolean coincideAnio = anio == null || proyecto.getAnio() == anio;
            // Añadimos los proyectos que cumplen los dos filtros.
            if (coincideCategoria && coincideAnio) {
                resultado.add(proyecto);
            }
        }
        return resultado;
    }
}