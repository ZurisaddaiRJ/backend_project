/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.uv.Ferreteria.modelos.VistaNotaVentaPedidoEnProceso;
import org.uv.Ferreteria.servicio.VistaNotaVentaPedidoEnProcesoService;
/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/api/vista-nota-venta-pedido-en-proceso")
@CrossOrigin(origins="*")
public class VistaNotaVentaPedidoEnProcesoController {
    @Autowired
    private VistaNotaVentaPedidoEnProcesoService vistaNotaVentaPedidoEnProcesoService;

    @GetMapping
    public ResponseEntity<List<VistaNotaVentaPedidoEnProceso>> getAllVistaNotaVentaPedidoEnProceso() {
        return ResponseEntity.ok(vistaNotaVentaPedidoEnProcesoService.getAllVistaNotaVentaPedidoEnProceso());
    }
}
