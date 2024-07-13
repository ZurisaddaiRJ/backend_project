/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.Ferreteria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.uv.Ferreteria.modelos.NotaVenta;

/**
 *
 * @author loken
 */
public interface NotaVentaRepository extends JpaRepository<NotaVenta, Long> {

    // Consulta para encontrar el máximo número de nota
    @Query("SELECT MAX(n.numeroNota) FROM NotaVenta n")
    Long findMaxNumeroNota();
}