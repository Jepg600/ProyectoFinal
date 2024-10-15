package com.example.proyectofinalfullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "comentarios")
public class Comentario {
    @Id
    private String id;
    private Long productoId;
    private Long clienteId;
    private String contenido;
    private Integer calificacion;
}