package com.example.proyectofinalfullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "productos_relacionados")
public class ProductoRelacionado {
    @Id
    private String id;
    private Long productoId;
    private List<Long> productosRelacionadosIds;
}