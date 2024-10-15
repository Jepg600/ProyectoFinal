package com.example.proyectofinalfullstack.repository;

import com.example.proyectofinalfullstack.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    @Query("SELECT v FROM Venta v WHERE (:clienteId IS NULL OR v.cliente.id = :clienteId) " +
           "AND (:fechaInicio IS NULL OR v.fecha >= :fechaInicio) " +
           "AND (:fechaFin IS NULL OR v.fecha <= :fechaFin)")
    List<Venta> findVentasByFilters(Long clienteId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}