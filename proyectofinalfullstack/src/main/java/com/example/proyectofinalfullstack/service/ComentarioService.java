package com.example.proyectofinalfullstack.service;

import com.example.proyectofinalfullstack.model.Comentario;
import com.example.proyectofinalfullstack.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> getComentariosByProductoId(Long productoId) {
        return comentarioRepository.findByProductoId(productoId);
    }

    public Comentario saveComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
}