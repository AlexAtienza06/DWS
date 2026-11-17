package com.example.portfolioCV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Inicio {
    @GetMapping("/")
    public String inicio(Model model) {

        model.addAttribute("mensaje", "Mi currículum y portfolio web");

        return "inicio";
    }
}