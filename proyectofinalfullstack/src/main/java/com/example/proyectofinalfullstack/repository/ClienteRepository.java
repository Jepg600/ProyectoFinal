package com.example.proyectofinalfullstack.repository;

import com.example.proyectofinalfullstack.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}