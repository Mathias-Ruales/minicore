package com.minicore.demo.controller;

import com.minicore.demo.dto.TareaDto;
import com.minicore.demo.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ReporteController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/reporte")
    public String generarReporte(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin,
            Model model) {
        
        List<TareaDto> tareas = tareaService.obtenerTareasPasadasEnProgreso(fechaInicio, fechaFin);
        model.addAttribute("tareas", tareas);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        
        return "reporte";
    }
}
