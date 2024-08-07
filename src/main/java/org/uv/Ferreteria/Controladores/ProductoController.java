/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Ferreteria.Controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.uv.Ferreteria.DTOs.DTOProductoInfo;
import org.uv.Ferreteria.modelos.Producto;
import org.uv.Ferreteria.servicio.ProductoService;

/**
 *
 * @author loken
 */
@Controller
@RequestMapping("api/productos")
@CrossOrigin(origins="*")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
 
    @PostMapping
    public ResponseEntity<org.uv.Ferreteria.DTOs.DTOProductoInfo> crearProductoConEntidades(@Valid @RequestBody Producto nuevoProducto) {
        org.uv.Ferreteria.DTOs.DTOProductoInfo productoCreado = productoService.crearProducto(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTOProductoInfo>> obtenerProductos(){
        List<DTOProductoInfo> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOProductoInfo> obtenerProductoPorId(@PathVariable Long id){
        DTOProductoInfo producto = productoService.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOProductoInfo> actualizarProducto(@PathVariable Long id, @Valid @RequestBody Producto producto){
        DTOProductoInfo productoActualizado = productoService.modificarProducto(producto, id);
        return ResponseEntity.ok(productoActualizado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DTOProductoInfo>> buscarProductoPorNombre(@RequestParam String nombre){
        List<DTOProductoInfo> productos = productoService.buscarProductoPorNombre(nombre);
        return ResponseEntity.ok(productos);
    }

    /*
    @GetMapping("/get")
    public ResponseEntity<List<Producto>> obtenerProductosSinInfo(){
        List<Producto> productos = productoService.obtenerProductosSinInfo();
        return ResponseEntity.ok(productos);
    }
     */
}
