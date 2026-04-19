package com.minicore.demo.repository;

import com.minicore.demo.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    
    @Query("SELECT t FROM Tarea t WHERE t.estado = :estado AND t.fechaInicio >= :fechaInicio AND t.fechaInicio <= :fechaFin")
    List<Tarea> findByEstadoAndFechaInicioBetween(@Param("estado") String estado, @Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
}
