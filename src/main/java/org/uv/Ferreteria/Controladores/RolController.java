/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.Controladores;
import java.util.List;
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
import org.uv.Ferreteria.DTOs.DTORol;
import org.uv.Ferreteria.modelos.Rol;
import org.uv.Ferreteria.servicio.RolService;

/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/roles")
@CrossOrigin(origins="*")
public class RolController {
    @Autowired
    private RolService rolService;
 
    @PostMapping
    public ResponseEntity<org.uv.Ferreteria.DTOs.DTORol> crearRolConEntidades(@Valid @RequestBody Rol nuevoRol) {
        org.uv.Ferreteria.DTOs.DTORol rolCreado = rolService.crearRol(nuevoRol);
        return ResponseEntity.status(HttpStatus.CREATED).body(rolCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTORol>> obtenerRoles(){
        List<DTORol> roles = rolService.obtenerRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTORol> obtenerRolesPorId(@PathVariable Long id){
        DTORol rol = rolService.obtenerRolesPorId(id);
        return ResponseEntity.ok(rol);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DTORol> actualizarRoles(@PathVariable Long id,@Valid @RequestBody Rol rolActualizado) {
        DTORol rol = rolService.actualizarRol(id, rolActualizado);
        return ResponseEntity.ok(rol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
