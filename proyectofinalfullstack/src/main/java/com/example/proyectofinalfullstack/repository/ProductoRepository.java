package com.example.proyectofinalfullstack.repository;

import com.example.proyectofinalfullstack.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}