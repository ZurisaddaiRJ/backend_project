/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.Controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Ferreteria.DTOs.DTONotaVenta;
import org.uv.Ferreteria.DTOs.Entradas.DTOPago;
import org.uv.Ferreteria.DTOs.DTOVenta;
import org.uv.Ferreteria.modelos.NotaVenta;
import org.uv.Ferreteria.servicio.NotaVentaService;
import org.uv.Ferreteria.servicio.PedidoServicio;

/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/notasventas")
@CrossOrigin(origins = "*")
public class NotaVentaController {

    @Autowired
    private NotaVentaService notaventaService;

    @Autowired
    private PedidoServicio pedidoService;

    //postmapping para crear una nota de venta con metdo limpio
    @PostMapping("/crearlimpio")
    public ResponseEntity<String> crearNota(@Valid @RequestBody NotaVenta notaVenta) {
        try {
            notaventaService.crandoVenta(notaVenta);
            return new ResponseEntity<>("Nota de venta creada con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<DTOVenta>> obtenerNotasVentas() {
        List<DTOVenta> notasventas = notaventaService.obtenerNotasVentas();
        return ResponseEntity.ok(notasventas);
    }

    @GetMapping("/lastNoteNumber")
    public ResponseEntity<Long> findMaxNumeroNota() {
        try {
            Long maxNumeroNota = pedidoService.obtenerUltimoNumeroNota();
            return ResponseEntity.ok(maxNumeroNota);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOVenta> obtenerNotasVentasPorId(@PathVariable Long id) {
        DTOVenta notasventas = notaventaService.obtenerNotaVentaPorId(id);
        return ResponseEntity.ok(notasventas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTONotaVenta> actualizarNotaVenta(@PathVariable Long id, @Valid @RequestBody NotaVenta notaventaActualizado) {
        DTONotaVenta notaventa = notaventaService.actualizarNotaVenta(id, notaventaActualizado);
        return ResponseEntity.ok(notaventa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotaVenta(@PathVariable Long id) {
        notaventaService.eliminarNotaVenta(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/pagarnota")
    public ResponseEntity<String> pagarNota(@RequestBody DTOPago pago) {
        try {
            return new ResponseEntity<>(notaventaService.PagarNotaVenta(pago), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}