package com.example.proyectofinalfullstack.repository;

import com.example.proyectofinalfullstack.model.ProductoRelacionado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRelacionadoRepository extends MongoRepository<ProductoRelacionado, String> {
    ProductoRelacionado findByProductoId(Long productoId);
}