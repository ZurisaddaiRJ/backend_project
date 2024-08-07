/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Ferreteria.DTOs;

import org.uv.Ferreteria.modelos.Producto;

/**
 *
 * @author loken
 */ 
public class DTOProductoInfo {
    
    private long codigo;
    
    private long existencia;
    
    private double precio;
    
    private String nombre;
    
    private long idMarca;
    private String marca;

    private long idUnidadMedida;
    private String unidadMedida;
    
    private long idCategoria;
    private String categoria;

    public DTOProductoInfo() {
    }

    public DTOProductoInfo(long codigo, String nombre, long existencia, double precio, String marca, String unidadMedida, String categoria) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.existencia = existencia;
        this.marca = marca;
        this.unidadMedida = unidadMedida;
        this.categoria = categoria;
        this.precio = precio;
    }

    public DTOProductoInfo(Producto producto){
        this.codigo = producto.getCodigo();
        this.nombre = producto.getNombre();
        this.existencia = producto.getExistencia();
        this.precio = producto.getPrecio();
        this.marca = producto.getMarca().getNombre();
        this.unidadMedida = producto.getUnidadMedida().getNombre();
        this.categoria = producto.getCategoria().getNombre();
        this.idMarca = producto.getMarca().getIdMarca();
        this.idUnidadMedida = producto.getUnidadMedida().getIdUnidadMed();
        this.idCategoria = producto.getCategoria().getIdCategoria();
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getExistencia() {
        return existencia;
    }

    public void setExistencia(long existencia) {
        this.existencia = existencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(long idMarca) {
        this.idMarca = idMarca;
    }

    public long getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(long idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}
