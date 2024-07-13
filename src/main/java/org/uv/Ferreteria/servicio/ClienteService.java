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
import org.uv.Ferreteria.DTOs.DTOCliente;
import org.uv.Ferreteria.modelos.Cliente;
import org.uv.Ferreteria.repositorio.ClienteRepository;

/**
 *
 * @author yacruz
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public DTOCliente crearCliente(@Valid Cliente cliente) {
        
        Cliente clienteG = clienteRepository.save(cliente);
        
        org.uv.Ferreteria.DTOs.DTOCliente dto = new DTOCliente(clienteG);
        
        return dto;
    }
    
    public List<DTOCliente> obtenerClientes() {
        List<DTOCliente> DTOclientes = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();

        // Convertir cada producto a DTOProductoInfo
        for (Cliente cliente : clientes) {
            DTOCliente dto = new DTOCliente(cliente);
            DTOclientes.add(dto);
        }

        return DTOclientes;
    }
    
    public DTOCliente obtenerClientePorId(long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        DTOCliente dto = new DTOCliente(cliente);

        return dto;
    }
    
    public DTOCliente actualizarCliente(Long idCliente,@Valid Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        // Update fields
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setApellidos(clienteActualizado.getApellidos());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setDireccion(clienteActualizado.getDireccion());

        // Save the updated employee
        Cliente clienteG = clienteRepository.save(clienteExistente);

        // Convert to DTO and return
        DTOCliente dto = new DTOCliente(clienteG);
        return dto;
    }

    public void eliminarCliente(Long idCliente) {
        Cliente clienteExistente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        // Delete the employee
        clienteRepository.delete(clienteExistente);
    }
}
