package com.example.p3p4springboot;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
public class MaterialController {

    private final String[][] materiales = {
            {"PORTATIL", "Ordenador portátil.", "Incluye cargador y una funda."},
            {"MICRO", "Kit de microcontrolador.", "Incluye una placa y un cable USB."},
            {"CAMARA", "Cámara de documentación.", "Incluye soporte de mesa."}
    };

    // Muestra el catálogo en la página principal.
    @GetMapping("/")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("materiales", materiales);
        return "catalogo";
    }

    // Buscar un material por su código dentro del array.
    private String[] buscarMaterial(String codigo) {
        for (String[] material : materiales) {
            if (material[0].equalsIgnoreCase(codigo)) {
                return material;
            }
        }
        return null;
    }

    // Muestra la ficha del material y el turno solicitado.
    @GetMapping("/materiales/{codigo}")
    public String mostrarMaterial(@PathVariable String codigo, @RequestParam(defaultValue = "general") String turno, Model model) {
        String[] material = buscarMaterial(codigo);

        // Un código inexistente debe producir un HTTP 404 real.
        if (material == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("material", material);
        model.addAttribute("turno", turno);
        return "material";
    }

    // Abre el formulario y prepara los datos que necesita la plantilla.
    @GetMapping("/solicitud/nueva")
    public String mostrarFormulario(Model model) {

        // Crea un DTO vacío para enlazarlo con los campos del formulario.
        model.addAttribute("solicitud", new SolicitudPrestamo());

        // Envía el catálogo para mostrar las opciones del selector.
        model.addAttribute("materiales", materiales);

        // Devuelve la plantilla solicitud.html.
        return "solicitud";
    }


    // Recibe los datos del formulario y ejecuta las validaciones del DTO.
    @PostMapping("/solicitudes")
    public String procesarSolicitud(
            @Valid @ModelAttribute("solicitud") SolicitudPrestamo solicitud,
            BindingResult resultado,
            Model model) {

        // Comprueba que el material elegido exista en el catálogo.
        if (buscarMaterial(solicitud.getMaterial()) == null) {
            resultado.rejectValue(
                    "material",
                    "material.invalido",
                    "Debes seleccionar un material del catálogo.");
        }

        // Comprueba que las fechas estén introducidas y sean correctas.
        LocalDate recogida = solicitud.getFechaRecogida();
        LocalDate devolucion = solicitud.getFechaDevolucion();

        // La devolución no puede ser anterior a la recogida.
        if (recogida != null && devolucion != null
                && devolucion.isBefore(recogida)) {
            resultado.rejectValue(
                    "fechaDevolucion",
                    "fechaDevolucion.invalida",
                    "La devolución no puede ser anterior a la recogida.");
        }

        // Si hay errores, vuelve al formulario conservando sus opciones.
        if (resultado.hasErrors()) {
            model.addAttribute("materiales", materiales);
            return "solicitud";
        }

        // Busca los datos completos del material seleccionado.
        String[] materialSeleccionado = buscarMaterial(solicitud.getMaterial());

        // Cuenta ambos días: el de recogida y el de devolución.
        long diasPrestamo = ChronoUnit.DAYS.between(recogida, devolucion) + 1;

        // Calcula el total de días-unidad solicitados.
        long totalDiasUnidad = diasPrestamo * solicitud.getUnidades();

        // Envía los datos necesarios a la página de resultado.
        model.addAttribute("solicitud", solicitud);
        model.addAttribute("materialSeleccionado", materialSeleccionado);
        model.addAttribute("diasPrestamo", diasPrestamo);
        model.addAttribute("totalDiasUnidad", totalDiasUnidad);

        return "resultado";
    }


}