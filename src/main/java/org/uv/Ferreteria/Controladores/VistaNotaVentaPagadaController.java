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
import org.uv.Ferreteria.modelos.VistaNotaVentaPagada;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.uv.Ferreteria.servicio.VistaNotaVentaPagadaService;
/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/api/vista-nota-venta-pagada")
@CrossOrigin(origins="*")
public class VistaNotaVentaPagadaController {
    @Autowired
    private VistaNotaVentaPagadaService vistaNotaVentaPagadaService;

    @GetMapping
    public ResponseEntity<List<VistaNotaVentaPagada>> getAllVistaNotaVentaPagada() {
        return ResponseEntity.ok(vistaNotaVentaPagadaService.getAllVistaNotaVentaPagada());
    }
}
