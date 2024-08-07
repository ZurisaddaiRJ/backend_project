/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.Ferreteria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.Ferreteria.modelos.Anticipo;

/**
 *
 * @author loken
 */
public interface AnticipoRepository extends JpaRepository<Anticipo, Long> {
    
}
