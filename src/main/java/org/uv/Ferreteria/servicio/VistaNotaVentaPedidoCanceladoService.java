/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.uv.Ferreteria.modelos.VistaNotaVentaPedidoCancelado;
import org.uv.Ferreteria.repositorio.VistaNotaVentaPedidoCanceladoRepository;
/**
 *
 * @author yacruz
 */
@Service
public class VistaNotaVentaPedidoCanceladoService {
    @Autowired
    private VistaNotaVentaPedidoCanceladoRepository vistaNotaVentaPedidoCanceladoRepository;

    public List<VistaNotaVentaPedidoCancelado> getAllVistaNotaVentaPedidoCancelado() {
        return vistaNotaVentaPedidoCanceladoRepository.findAll();
    }
}
