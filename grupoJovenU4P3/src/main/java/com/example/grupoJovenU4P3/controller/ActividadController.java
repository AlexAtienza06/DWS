package com.example.grupoJovenU4P3.controller;

import com.example.grupoJovenU4P3.dto.ActividadForm;
import com.example.grupoJovenU4P3.model.Actividad;
import com.example.grupoJovenU4P3.service.ActividadService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ActividadController {
    private final ActividadService actividadService;

    // El controlador utiliza el servicio para gestionar las actividades.
    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping("/")
    public String listarActividades(Model model) {
        model.addAttribute("actividades", actividadService.listarActividades());
        // Se añade un formulario vacío para poder registrar actividades desde esta página.
        model.addAttribute("actividadForm", new ActividadForm());
        return "actividades";
    }

    @PostMapping("/actividad/guardar")
    public String guardarActividad(
            @Valid @ModelAttribute("actividadForm") ActividadForm actividadForm, BindingResult resultado, Model model) {
        // Si hay errores, se vuelve a mostrar el formulario con los datos y los mensajes de validación.
        if (resultado.hasErrors()) {
            model.addAttribute("actividades", actividadService.listarActividades());
            return "actividades";
        }

        actividadService.guardarActividad(actividadForm);
        // Se redirige al listado para mostrar los cambios después de guardar.
        return "redirect:/";
    }

    @GetMapping("/actividad/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Actividad actividad = actividadService.buscarPorId(id).orElse(null);

        // Si no existe una actividad con ese identificador, se vuelve al listado.
        if (actividad == null) {
            return "redirect:/";
        }

        model.addAttribute("actividad", actividad);
        return "formularioActividad";
    }

    @PostMapping("/actividad/actualizar")
    public String actualizarActividad(
            @Valid @ModelAttribute("actividad") Actividad actividad,
            BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "formularioActividad";
        }
        actividadService.guardarActividad(actividad);
        return "redirect:/";
    }

    @PostMapping("/actividad/eliminar/{id}")
    public String eliminarActividad(@PathVariable Long id) {
        actividadService.eliminarActividad(id);
        return "redirect:/";
    }

    @GetMapping("/actividad/{id}")
    public String verActividad(@PathVariable Long id, Model model) {
        Actividad actividad = actividadService.buscarPorId(id).orElse(null);
        if (actividad == null) {
            return "redirect:/";
        }
        model.addAttribute("actividad", actividad);
        return "detalleActividad";
    }
}