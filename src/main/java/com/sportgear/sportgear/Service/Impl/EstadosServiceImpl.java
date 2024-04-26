package com.sportgear.sportgear.Service.Impl;

import com.sportgear.sportgear.Model.Estado;
import com.sportgear.sportgear.Repository.EstadosRepository;
import com.sportgear.sportgear.Service.EstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para la gestión de estados.
 */
@Service
public class EstadosServiceImpl implements EstadosService {

     @Autowired
     private EstadosRepository estadosRepository;

    /**
     * Obtiene una lista de todos los estados.
     *
     * @return Lista de estados.
     */
    @Override
    public List<Estado> listarEstados() {
        return estadosRepository.findAll();
    }
}
