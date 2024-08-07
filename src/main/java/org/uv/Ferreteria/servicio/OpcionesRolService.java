/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Ferreteria.DTOs.DTOOpcionesRol;
import org.uv.Ferreteria.modelos.OpcionesRol;
import org.uv.Ferreteria.modelos.OpcionesSistema;
import org.uv.Ferreteria.modelos.Rol;
import org.uv.Ferreteria.repositorio.OpcionesRolRepository;
import org.uv.Ferreteria.repositorio.OpcionesSistemaRepository;
import org.uv.Ferreteria.repositorio.RolRepository;

/**
 *
 * @author yacruz
 */
@Service
public class OpcionesRolService {

    @Autowired
    private OpcionesRolRepository opcionesRolRepository;

    @Autowired
    private OpcionesSistemaRepository opcionesSistemaRepository;

    @Autowired
    private RolRepository rolRepository;

    public DTOOpcionesRol crearOpcionRol(@Valid OpcionesRol opcionesRol) {
        try {
            // Verificar si el rol existe
            Rol rol = rolRepository.findById(opcionesRol.getRoles().getIdRol())
                    .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

            // Verificar si la opcion de sistema existe
            OpcionesSistema opcionesSistema = opcionesSistemaRepository.findById(opcionesRol.getOpcionesSistema().getIdOpciones())
                    .orElseThrow(() -> new EntityNotFoundException("Opcion de sistema no encontrado"));

            opcionesRol.setOpcionesSistema(opcionesSistema);
            opcionesRol.setRoles(rol);

            OpcionesRol opcionesRolG = opcionesRolRepository.save(opcionesRol);

            org.uv.Ferreteria.DTOs.DTOOpcionesRol dto = new DTOOpcionesRol(opcionesRolG);

            return dto;
        } catch (Exception ex) {
            throw new RuntimeException("Se produjo un error al crear la opcion del rol.", ex);
        }

    }

    public List<DTOOpcionesRol> obtenerOpcionesRoles() {
        List<DTOOpcionesRol> dTOOpcionesRols = new ArrayList<>();
        List<OpcionesRol> opcionesRol = opcionesRolRepository.findAll();

        // Convertir cada producto a DTOProductoInfo
        for (OpcionesRol opcionesrol : opcionesRol) {
            DTOOpcionesRol dto = new DTOOpcionesRol(opcionesrol);
            dTOOpcionesRols.add(dto);
        }

        return dTOOpcionesRols;
    }

    public DTOOpcionesRol obtenerOpcionTolPorId(long idOpcionRol) {
        OpcionesRol opcionesRol = opcionesRolRepository.findById(idOpcionRol)
                .orElseThrow(() -> new EntityNotFoundException("Opcion de rol no encontrado"));

        DTOOpcionesRol dto = new DTOOpcionesRol(opcionesRol);

        return dto;
    }

    public DTOOpcionesRol actualizarOpcionRol(Long idOpcionRol, @Valid OpcionesRol opcionesRolActualizado) {
        try {
            OpcionesRol opcionesrolExistente = opcionesRolRepository.findById(idOpcionRol)
                    .orElseThrow(() -> new EntityNotFoundException("Opcion de rol no encontrado"));

            // Update fields
            opcionesrolExistente.setOpcionesSistema(opcionesRolActualizado.getOpcionesSistema());
            opcionesrolExistente.setRoles(opcionesRolActualizado.getRoles());

            // Save the updated employee
            OpcionesRol opcionesRolG = opcionesRolRepository.save(opcionesrolExistente);

            // Convert to DTO and return
            DTOOpcionesRol dto = new DTOOpcionesRol(opcionesRolG);
            return dto;
        } catch (Exception ex) {
            throw new RuntimeException("Se produjo un error al actualizar la opcion del rol.", ex);
        }

    }

    public void eliminarOpocionRol(Long idOpcionRol) {
        OpcionesRol opcionRolExistente = opcionesRolRepository.findById(idOpcionRol)
                .orElseThrow(() -> new EntityNotFoundException("Opcion rol no encontrada"));

        // Delete the employee
        opcionesRolRepository.delete(opcionRolExistente);
    }
}
