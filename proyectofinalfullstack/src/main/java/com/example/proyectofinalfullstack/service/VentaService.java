package com.example.proyectofinalfullstack.service;

import com.example.proyectofinalfullstack.model.DetalleVenta;
import com.example.proyectofinalfullstack.model.Producto;
import com.example.proyectofinalfullstack.model.Venta;
import com.example.proyectofinalfullstack.repository.ProductoRepository;
import com.example.proyectofinalfullstack.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id: " + id));
    }

    @Transactional
    public Venta saveVenta(Venta venta) {
        venta.setFecha(LocalDateTime.now());
        for (DetalleVenta detalle : venta.getDetalles()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            if (producto.getInventario() < detalle.getCantidad()) {
                throw new RuntimeException("Inventario insuficiente para el producto: " + producto.getNombre());
            }
            producto.setInventario(producto.getInventario() - detalle.getCantidad());
            productoRepository.save(producto);
        }
        return ventaRepository.save(venta);
    }

    public List<Venta> getVentasByFilters(Long clienteId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return ventaRepository.findVentasByFilters(clienteId, fechaInicio, fechaFin);
    }
}