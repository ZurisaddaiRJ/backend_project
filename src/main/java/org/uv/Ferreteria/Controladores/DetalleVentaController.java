/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.Controladores;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Ferreteria.DTOs.DTODetalleVenta;
import org.uv.Ferreteria.DTOs.DTODetallesVentas;
import org.uv.Ferreteria.DTOs.DTOReporte;
import org.uv.Ferreteria.DTOs.Entradas.DTOCrearReporte;
import org.uv.Ferreteria.modelos.DetalleVenta;
import org.uv.Ferreteria.modelos.Reporte;
import org.uv.Ferreteria.servicio.DetalleVentaService;
/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("api/detallesventas")
@CrossOrigin(origins="*")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleventaService;
 
    @PostMapping
    public ResponseEntity<org.uv.Ferreteria.DTOs.DTODetalleVenta> crearDetalleVentaConEntidades(@Valid @RequestBody DetalleVenta nuevoDetalleVenta) {
        org.uv.Ferreteria.DTOs.DTODetalleVenta detalleventaCreado = detalleventaService.crearDetalleVenta(nuevoDetalleVenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleventaCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTODetalleVenta>> obtenerDetallesVentas(){
        List<DTODetalleVenta> detalleventas = detalleventaService.obtenerDetallesVenta();
        return ResponseEntity.ok(detalleventas);
    }
    
    @GetMapping("/byNumeroNota/{numeroNota}")
    public List<DTODetallesVentas> getDetalleVentaByNumeroNota(@PathVariable Long numeroNota) {
        List<DetalleVenta> detallesEncontrados = detalleventaService.getDetalleVentaByNumeroNota(numeroNota);
        List<DTODetallesVentas> detallesVentas = new ArrayList<>();
        for (DetalleVenta detalle : detallesEncontrados) {
            DTODetallesVentas detalleVenta = new DTODetallesVentas();
            detalleVenta.setCantidad(detalle.getCantidad());
            detalleVenta.setSubtotal(detalle.getSubtotal().doubleValue());
            detalleVenta.setCodigo(detalle.getProducto().getCodigo());
            detalleVenta.setNombre(detalle.getProducto().getNombre());
            detalleVenta.setExistencia(detalle.getProducto().getExistencia());
            detallesVentas.add(detalleVenta);
        }
        return detallesVentas;
    }
    

    @PostMapping("/crearReporteMensual")
    public ResponseEntity<DTOReporte> CrearReporte(@RequestBody DTOCrearReporte reporte) {

        Reporte nuevoReporte = detalleventaService.CrearReporteMensual(reporte);
        DTOReporte dtoReporte = new DTOReporte(nuevoReporte);
        return ResponseEntity.ok(dtoReporte);
    }

    @PostMapping("/crearReporteSemanal")
    public ResponseEntity<DTOReporte> CrearReporteSemanal(@RequestBody DTOCrearReporte reporte) {

        Reporte nuevoReporte = detalleventaService.CrearReporteSemanal(reporte);
        DTOReporte dtoReporte = new DTOReporte(nuevoReporte);
        return ResponseEntity.ok(dtoReporte);
    }

    @PutMapping("/actualizarReporteMensual/{id}")
    public ResponseEntity<DTOReporte> ActualizarReporte(@PathVariable Long id) {

        Reporte nuevoReporte = detalleventaService.actualizarReporteMensual(id);
        DTOReporte dtoReporte = new DTOReporte(nuevoReporte);
        return ResponseEntity.ok(dtoReporte);
    }

    @PutMapping("/actualizarReporteSemanal/{id}")
    public ResponseEntity<DTOReporte> ActualizarReporteSemanal(@PathVariable Long id) { 
        Reporte nuevoReporte = detalleventaService.actualizarReporteSemanal(id);
        DTOReporte dtoReporte = new DTOReporte(nuevoReporte);
        return ResponseEntity.ok(dtoReporte);
    }

}
