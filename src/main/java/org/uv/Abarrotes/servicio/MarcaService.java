/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.repositorio.MarcaRepository;
import org.uv.Abarrotes.DTOs.DTOmarca;
import org.uv.Abarrotes.modelos.Marca;
/**
 *
 * @author loken
 */
@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    //obtener todas las marcas registradas
    public List<Marca> obtenerMarcas(){
        return marcaRepository.findAll();
    }

    public List<Marca> obtenerMarcaSinInfo(){
        return marcaRepository.findAll();
    }
    
    //obtener una marca por id
    public Optional<DTOmarca> obtenerMarcaPorId(Long id){
        Optional<Marca> marca = marcaRepository.findById(id);
        if(marca.isPresent()){
            return Optional.of(new DTOmarca(marca.get()));
        }
        return Optional.empty();
    }

    //obtener una marca por nombre
    public Marca crearMarca(Marca marca){
        return marcaRepository.save(marca);
    }

    //eliminar una marca por id
    public Optional<Marca> actualizarMarca(Long id, Marca marca){
        if(!marcaRepository.existsById(id)){
            return Optional.empty();
        }
        marca.setIdMarca(id);
        return Optional.of(marcaRepository.save(marca));
    }

    //eliminar una marca por id
    public boolean eliminarMarca(Long id){
        if(!marcaRepository.existsById(id)){
            return false;
        }
        marcaRepository.deleteById(id);
        return true;
    }
}
