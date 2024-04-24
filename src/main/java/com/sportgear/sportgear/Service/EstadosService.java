package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Estado;

import java.util.List;

/**
 * Interfaz que define los métodos para el servicio de gestión de estados.
 */
public interface EstadosService {

    /**
     * Obtiene una lista de todos los estados.
     *
     * @return Lista de estados.
     */
    List<Estado> listarEstados();
}
