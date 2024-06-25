/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;


import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.uv.Abarrotes.DTOs.DTOEmpleadoInfo;
import org.uv.Abarrotes.DTOs.Entradas.DTOCrearEmpleado;
import org.uv.Abarrotes.modelos.Empleado;
import org.uv.Abarrotes.servicio.EmpleadoService;

/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/empleados")
@CrossOrigin(origins="*")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
 
    @PostMapping
    public ResponseEntity<DTOEmpleadoInfo> crearEmpleadoConEntidades(@Valid @RequestBody Empleado nuevoEmpleado, @RequestParam String descripcionRol) {
        try {
            DTOEmpleadoInfo empleadoCreado = empleadoService.crearEmpleado(nuevoEmpleado, descripcionRol);
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCreado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DTOEmpleadoInfo>> obtenerEmpleados(){
        List<DTOEmpleadoInfo> empleados = empleadoService.obtenerEmpleados();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEmpleadoInfo> obtenerEmpleadoPorId(@PathVariable Long id){
        DTOEmpleadoInfo empleado = empleadoService.obtenerEmpleadoPorId(id);
        return ResponseEntity.ok(empleado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DTOEmpleadoInfo> actualizarEmpleado(@PathVariable Long id,@Valid @RequestBody Empleado empleadoActualizado) {
        DTOEmpleadoInfo empleado = empleadoService.actualizarEmpleado(id, empleadoActualizado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }

    //Metodo para buscar empleados por nombres y apellidos
    @GetMapping("/buscar")
    public ResponseEntity<List<DTOEmpleadoInfo>> buscarEmpleadosPorNombreYApellidos(
         @RequestParam(value = "nombre", required = false) String nombre,
         @RequestParam(value = "apellidos", required = false) String apellidos) {
        List<DTOEmpleadoInfo> empleados = empleadoService.buscarEmpleadosPorNombreYApellidos(nombre, apellidos);
        return ResponseEntity.ok(empleados);
    }

    @PostMapping("/crearConDTO")
    public ResponseEntity<DTOEmpleadoInfo> crearEmpleadoConDTO(@Valid @RequestBody DTOCrearEmpleado dto) {
        DTOEmpleadoInfo empleadoCreado = empleadoService.crearEmpleadoConDTO(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCreado);
    } 
}