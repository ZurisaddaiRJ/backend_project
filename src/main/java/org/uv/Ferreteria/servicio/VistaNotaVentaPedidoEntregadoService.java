/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Ferreteria.modelos.VistaNotaVentaPedidoEntregado;
import org.uv.Ferreteria.repositorio.VistaNotaVentaPedidoEntregadoRepository;
import java.util.List;
/**
 *
 * @author yacruz
 */
@Service
public class VistaNotaVentaPedidoEntregadoService {
    @Autowired
    private VistaNotaVentaPedidoEntregadoRepository vistaNotaVentaPedidoEntregadoRepository;

    public List<VistaNotaVentaPedidoEntregado> getAllVistaNotaVentaPedidoEntregado() {
        return vistaNotaVentaPedidoEntregadoRepository.findAll();
    }
}
