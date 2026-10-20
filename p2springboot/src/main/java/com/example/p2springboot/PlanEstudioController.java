package com.example.p2springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlanEstudioController {

    @GetMapping("/")
    public String mostrarPlan(
            @RequestParam(defaultValue = "estudiante") String nombre,
            Model model) {

        List<String> asignaturas = Arrays.asList(
                "Programación",
                "Bases de datos",
                "Lenguajes de marcas"
        );

        List<Integer> duraciones = Arrays.asList(25, 40, 30);

        int totalMinutos = 0;

        for (int duracion : duraciones) {
            totalMinutos += duracion;
        }

        model.addAttribute("nombre", nombre);
        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("duraciones", duraciones);
        model.addAttribute("totalMinutos", totalMinutos);

        return "plan";
    }
}
