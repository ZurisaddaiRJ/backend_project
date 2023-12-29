/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTODetalleVenta;
import org.uv.Abarrotes.modelos.DetalleVenta;
import org.uv.Abarrotes.modelos.NotaVenta;
import org.uv.Abarrotes.modelos.Producto;
import org.uv.Abarrotes.repositorio.DetalleVentaRepository;
import org.uv.Abarrotes.repositorio.NotaVentaRepository;
import org.uv.Abarrotes.repositorio.ProductoRepository;
/**
 *
 * @author yacruz
 */
@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private NotaVentaRepository notaventaRepository;
    
    public DTODetalleVenta crearDetalleVenta(DetalleVenta detalleventa) {
        
        Producto producto = productoRepository.findById(detalleventa.getProducto().getCodigo())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        
        NotaVenta notaventa = notaventaRepository.findById(detalleventa.getVenta().getNumeroNota())
                .orElseThrow(() -> new EntityNotFoundException("Nota de venta no encontrado"));

        detalleventa.setProducto(producto);
        detalleventa.setVenta(notaventa);
        
        DetalleVenta detalleventaG = detalleVentaRepository.save(detalleventa);
        
        org.uv.Abarrotes.DTOs.DTODetalleVenta dto = new DTODetalleVenta(detalleventaG);
        
        return dto;
    }

    public List<DTODetalleVenta> obtenerDetallesVenta() {
        List<DTODetalleVenta> DTOdetallesVenta = new ArrayList<>();
        List<DetalleVenta> detallesVenta = detalleVentaRepository.findAll();

        for (DetalleVenta detalleVenta : detallesVenta) {
            DTODetalleVenta dto = new DTODetalleVenta(detalleVenta);
            DTOdetallesVenta.add(dto);
        }

        return DTOdetallesVenta;
    }
    
    public List<DTODetalleVenta> getDetalleVentasEnRangoDeFechas(LocalDate startDate, LocalDate endDate) {
        // Convertir LocalDate a java.sql.Date
        Date sqlStartDate = Date.valueOf(startDate);
        Date sqlEndDate = Date.valueOf(endDate);
        List<DTODetalleVenta> DTOdetallesVenta = new ArrayList<>();
        List<DetalleVenta> detallesVenta = detalleVentaRepository.findByFechaBetween(sqlStartDate, sqlEndDate); 
        
        for (DetalleVenta detalleVenta : detallesVenta) {
            DTODetalleVenta dto = new DTODetalleVenta(detalleVenta);
            DTOdetallesVenta.add(dto);
        }

        return DTOdetallesVenta;
    }
} 
