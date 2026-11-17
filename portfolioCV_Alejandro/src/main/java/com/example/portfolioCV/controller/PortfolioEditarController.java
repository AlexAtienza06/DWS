package com.example.portfolioCV.controller;

import com.example.portfolioCV.model.PortfolioFormulario;
import com.example.portfolioCV.model.ProyectoFormulario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PortfolioEditarController {
    // Recoge el máximo de proyectos configurado en application.properties
    @Value("${portfolio.max-proyectos}")
    private int maxProyectos;

    // Permite obtener los mensajes en el idioma seleccionado
    private final MessageSource messageSource;

    public PortfolioEditarController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // Obtiene el mensaje correspondiente al idioma seleccionado
    private String texto(String clave, Locale locale) {
        return messageSource.getMessage(clave, null, locale);
    }

    // Muestra el formulario vacío al entrar en la página
    @GetMapping("/portfolio/editar")
    public String mostrarFormulario(Model model) {
        PortfolioFormulario formulario = new PortfolioFormulario();

        // Enviamos al HTML los datos necesarios para mostrar el formulario
        model.addAttribute("formulario", formulario);
        model.addAttribute("maxProyectos", maxProyectos);
        model.addAttribute("totalProyectos", formulario.getProyectos().size());
        model.addAttribute("errores", new HashMap<String, String>());
        model.addAttribute("hayErrores", false);

        return "portfolio-editar";
    }

    // Recibe las acciones realizadas en el formulario
    @PostMapping("/portfolio/editar")
    public String procesarFormulario(
            @ModelAttribute PortfolioFormulario formulario,
            @RequestParam String accion,
            Model model,
            Locale locale) {

        // Si no hay proyectos, creamos una lista vacía
        if (formulario.getProyectos() == null) {
            formulario.setProyectos(new ArrayList<>());
        }

        Map<String, String> errores = new HashMap<>();

        // Comprobamos el máximo de proyectos permitido
        if (formulario.getProyectos().size() > maxProyectos) {
            errores.put("proyectos", texto("error.maximo", locale));
        }

        // Si cambiamos el idioma, conservamos los datos del formulario
        if (accion.equals("idioma")) {
            model.addAttribute("formulario", formulario);
            model.addAttribute("maxProyectos", maxProyectos);
            model.addAttribute("totalProyectos", formulario.getProyectos().size());
            model.addAttribute("errores", errores);
            model.addAttribute("hayErrores", !errores.isEmpty());

            return "portfolio-editar";
        }

        // Añadimos o eliminamos proyectos según el botón pulsado
        modificarFilas(formulario, accion);

        // Volvemos a comprobar el máximo después de modificar las filas
        if (formulario.getProyectos().size() > maxProyectos) {
            errores.put("proyectos", texto("error.maximo", locale));
        }

        // Validamos los datos al generar la vista previa
        if (accion.equals("vistaPrevia")) {
            Map<String, String> erroresValidacion =
                    validarFormulario(formulario, locale);
            errores.putAll(erroresValidacion);

            // Si no hay errores, mostramos la vista previa
            if (errores.isEmpty()) {
                // Eliminamos las filas completamente vacías
                formulario.getProyectos().removeIf(proyecto ->
                        estaVacio(proyecto.getTitulo())
                                && estaVacio(proyecto.getAnio())
                                && estaVacio(proyecto.getCategoria())
                                && estaVacio(proyecto.getEstado())
                                && estaVacio(proyecto.getDescripcion())
                );

                model.addAttribute("formulario", formulario);
                return "portfolio-vista-previa";
            }
        }

        // Si volvemos desde la vista previa sin proyectos,
        // recuperamos una fila vacía para poder seguir editando
        if (accion.equals("volver")
                && formulario.getProyectos().isEmpty()) {
            formulario.getProyectos().add(new ProyectoFormulario());
        }

        // Enviamos de nuevo los datos y los errores al formulario
        model.addAttribute("formulario", formulario);
        model.addAttribute("maxProyectos", maxProyectos);
        model.addAttribute("totalProyectos", formulario.getProyectos().size());
        model.addAttribute("errores", errores);
        model.addAttribute("hayErrores", !errores.isEmpty());

        return "portfolio-editar";
    }

    // Añade o elimina filas del formulario
    private void modificarFilas(PortfolioFormulario formulario, String accion) {
        // Añadimos una fila vacía si todavía no se ha alcanzado el máximo
        if (accion.equals("anadir")) {
            if (formulario.getProyectos().size() < maxProyectos) {
                formulario.getProyectos().add(new ProyectoFormulario());
            }
            // Eliminamos la fila cuyo índice recibimos desde el formulario
        } else if (accion.startsWith("quitar:")) {
            try {
                int indice = Integer.parseInt(accion.substring(7));

                if (indice >= 0 && indice < formulario.getProyectos().size()) {
                    formulario.getProyectos().remove(indice);
                }
            } catch (NumberFormatException e) {
                // Si el índice no es válido, no eliminamos ninguna fila
            }

            // Siempre debe quedar al menos una fila visible
            if (formulario.getProyectos().isEmpty()) {
                formulario.getProyectos().add(new ProyectoFormulario());
            }
        }
    }

    // Comprueba que los datos personales y los proyectos sean correctos
    private Map<String, String> validarFormulario(
            PortfolioFormulario formulario, Locale locale) {

        Map<String, String> errores = new HashMap<>();

        // Validamos los datos personales
        if (estaVacio(formulario.getNombre())) {
            errores.put("nombre", texto("error.nombre", locale));
        }
        if (estaVacio(formulario.getTitular())) {
            errores.put("titular", texto("error.titular", locale));
        }
        if (estaVacio(formulario.getPresentacion())) {
            errores.put("presentacion", texto("error.presentacion", locale));
        }
        // El correo solo se valida si se ha introducido
        if (!estaVacio(formulario.getCorreo())) {
            String correo = formulario.getCorreo().trim();
            if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)+$")) {
                errores.put("correo", texto("error.correo", locale));
            }
        }
        // Comprobamos el máximo de proyectos permitido
        if (formulario.getProyectos().size() > maxProyectos) {
            errores.put("proyectos", texto("error.maximo", locale));
        }
        // Recorremos todos los proyectos para comprobar sus campos
        for (int i = 0; i < formulario.getProyectos().size(); i++) {
            ProyectoFormulario proyecto = formulario.getProyectos().get(i);
            String titulo = proyecto.getTitulo();
            String anio = proyecto.getAnio();
            String categoria = proyecto.getCategoria();
            String estado = proyecto.getEstado();
            String descripcion = proyecto.getDescripcion();
            // Comprobamos si la fila está completamente vacía
            boolean filaVacia =
                    estaVacio(titulo)
                            && estaVacio(anio)
                            && estaVacio(categoria)
                            && estaVacio(estado)
                            && estaVacio(descripcion);
            // Las filas vacías no necesitan validación
            if (filaVacia) {
                continue;
            }
            // Comprobamos los campos obligatorios
            if (estaVacio(titulo)) {
                errores.put("proyectos_" + i + "_titulo", texto("error.titulo", locale));
            }
            if (estaVacio(anio)) {
                errores.put("proyectos_" + i + "_anio", texto("error.anio", locale));
            } else {
                try {
                    // Comprobamos que el año sea un número entero
                    Integer.parseInt(anio);
                } catch (NumberFormatException e) {
                    errores.put("proyectos_" + i + "_anio", texto("error.anioValido", locale));
                }
            }
            if (estaVacio(categoria)) {
                errores.put("proyectos_" + i + "_categoria", texto("error.categoria", locale));
            } else if (!categoria.equals("Aplicaciones")
                    && !categoria.equals("Sitios web")
                    && !categoria.equals("Diseño")) {
                errores.put("proyectos_" + i + "_categoria", texto("error.categoriaValida", locale));
            }
            if (estaVacio(estado)) {
                errores.put("proyectos_" + i + "_estado", texto("error.estado", locale));
            } else if (!estado.equals("En curso")
                    && !estado.equals("Terminado")) {
                errores.put("proyectos_" + i + "_estado", texto("error.estadoValido", locale));
            }
            if (estaVacio(descripcion)) {
                errores.put("proyectos_" + i + "_descripcion", texto("error.descripcion", locale));
            }
        }
        return errores;
    }

    // Comprueba si un texto está vacío o solo contiene espacios
    private boolean estaVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}