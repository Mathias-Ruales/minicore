package com.minicore.demo.service;

import com.minicore.demo.dto.TareaDto;
import java.time.LocalDate;
import java.util.List;

public interface TareaService {
    List<TareaDto> obtenerTareasPasadasEnProgreso(LocalDate fechaInicio, LocalDate fechaFin);
}
