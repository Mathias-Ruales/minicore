package com.minicore.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TareaDto {
    private String nombreCompletoEmpleado;
    private String descripcionTarea;
    private String nombreProyecto;
    private LocalDate fechaInicio;
    private LocalDate fechaEstimada;
    private int diasPasados;
}
