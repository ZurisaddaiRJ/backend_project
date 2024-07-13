package org.uv.Ferreteria.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Ferreteria.DTOs.DTOCategoria;
import org.uv.Ferreteria.modelos.Categoria;
import org.uv.Ferreteria.repositorio.CategoriaRepository;

/**
 *
 * @author loken
 */
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria obtenerCategoriaPorId(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria crearCategoria(@Valid Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public boolean eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
        return true;
    }

    public Optional<Categoria> actualizarCategoria(Long id, @Valid Categoria categoria){
        if(!categoriaRepository.existsById(id)){
            return null;
        }
        categoria.setIdCategoria(id);
        return Optional.of(categoriaRepository.save(categoria));
    }

    public List<DTOCategoria> buscarCategoriaPorNombre(String nombre){
        List<Categoria> categorias = categoriaRepository.findByNombre(nombre);
        List<DTOCategoria> dtoCategoria = new ArrayList<>();
        for(Categoria cat : categorias){
            dtoCategoria.add(new DTOCategoria(cat));
        }

        return dtoCategoria;
    }
}
