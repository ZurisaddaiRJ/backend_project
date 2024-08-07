package org.uv.Ferreteria.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Ferreteria.DTOs.DTOEstadoPedido;
import org.uv.Ferreteria.modelos.EstadosPedido;
import org.uv.Ferreteria.repositorio.EstadosPedidoRepository;

@Service
public class EstadoPedidoService {
    @Autowired
    private EstadosPedidoRepository estadoPedidoRepository;

    public List<DTOEstadoPedido> obtenerEstadosPedido(){
        List<EstadosPedido> estadosPedido = estadoPedidoRepository.findAll();
        List<DTOEstadoPedido> dtoEstadosPedido = new ArrayList<>();
        for(EstadosPedido estadoPedido : estadosPedido){
            dtoEstadosPedido.add(new DTOEstadoPedido(estadoPedido));
        }
        return dtoEstadosPedido;
    }

    public DTOEstadoPedido obtenerEstadoPedidoPorNombre(String estado){
        EstadosPedido estadoPedido = estadoPedidoRepository.findByEstado(estado);
        return new DTOEstadoPedido(estadoPedido);
    }

    public DTOEstadoPedido obtenerEstadoPedidoPorId(Long id){
        Optional<EstadosPedido> estadoPedido = estadoPedidoRepository.findById(id);
        return new DTOEstadoPedido(estadoPedido.get());
    }

    public DTOEstadoPedido crearEstadoPedido(@Valid EstadosPedido estadoPedido){
        EstadosPedido nuevoEstadoPedido = estadoPedidoRepository.save(estadoPedido);
        return new DTOEstadoPedido(nuevoEstadoPedido);
    }

    public Optional<DTOEstadoPedido> actualizarEstadoPedido(Long id, @Valid EstadosPedido estadoPedido){
        if(!estadoPedidoRepository.existsById(id)){
            return Optional.empty();
        }
        estadoPedido.setIdEstado(id);
        return Optional.of(new DTOEstadoPedido(estadoPedidoRepository.save(estadoPedido)));
    }
}
