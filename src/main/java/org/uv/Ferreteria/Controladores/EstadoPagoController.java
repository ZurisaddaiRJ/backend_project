package org.uv.Ferreteria.Controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Ferreteria.DTOs.DTOEstadoPagos;
import org.uv.Ferreteria.modelos.EstadoPago;
import org.uv.Ferreteria.servicio.EstadoPagoService;

@RequestMapping("/api/estadopago")
@CrossOrigin(origins="*")
@RestController
public class EstadoPagoController {
    @Autowired
    private EstadoPagoService estadopagoService;


    @GetMapping
    public ResponseEntity<List<DTOEstadoPagos>> getAllEstadoPago() {
        List<EstadoPago> estadosPago = estadopagoService.getEstadospagos();
        List<DTOEstadoPagos> dto= new ArrayList<>();
        for (EstadoPago estadoPago : estadosPago) {
            dto.add(new DTOEstadoPagos(estadoPago));
        }

        return ResponseEntity.ok(dto);
    }
}
