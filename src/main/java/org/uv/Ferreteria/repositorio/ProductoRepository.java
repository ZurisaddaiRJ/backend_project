/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.Ferreteria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.Ferreteria.modelos.Producto;

/**
 *
 * @author loken
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
