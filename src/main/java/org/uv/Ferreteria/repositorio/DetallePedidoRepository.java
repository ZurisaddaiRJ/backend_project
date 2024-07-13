/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.Ferreteria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.Ferreteria.modelos.DetallePedido;

/**
 *
 * @author loken
 */
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>{
    
}