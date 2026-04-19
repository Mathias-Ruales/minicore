package com.minicore.demo.service;

import com.minicore.demo.dto.TareaDto;
import com.minicore.demo.models.Tarea;
import com.minicore.demo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<TareaDto> obtenerTareasPasadasEnProgreso(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Tarea> tareas = tareaRepository.findByEstadoAndFechaInicioBetween("En progreso", fechaInicio, fechaFin);
        List<TareaDto> dtos = new ArrayList<>();

        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            
            int diasPasados = 0;
            LocalDate fechaCalculo = (fechaFin != null) ? fechaFin : LocalDate.now();
            
            if (tarea.getFechaEstimada() != null && fechaCalculo.isAfter(tarea.getFechaEstimada())) {
                diasPasados = (int) ChronoUnit.DAYS.between(tarea.getFechaEstimada(), fechaCalculo);
            }

            TareaDto dto = TareaDto.builder()
                    .nombreCompletoEmpleado((tarea.getEmpleado() != null ? tarea.getEmpleado().getNombres() + " " + tarea.getEmpleado().getApellidos() : "N/A"))
                    .descripcionTarea(tarea.getDescripcion())
                    .nombreProyecto((tarea.getProyecto() != null ? tarea.getProyecto().getNombre() : "N/A"))
                    .fechaInicio(tarea.getFechaInicio())
                    .fechaEstimada(tarea.getFechaEstimada())
                    .diasPasados(diasPasados)
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }
}
