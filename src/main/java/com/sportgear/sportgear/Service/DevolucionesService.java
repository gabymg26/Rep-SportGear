package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Devoluciones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interfaz que define los métodos para el servicio de gestión de devoluciones.
 */
public interface DevolucionesService {

    /**
     * Obtiene una lista de todas las devoluciones.
     *
     * @return Lista de devoluciones.
     */
    List<Devoluciones> listarDevoluciones();

    /**
     * Registra una solicitud de devolución.
     *
     * @param devoluciones Objeto Devoluciones que representa la solicitud de devolución.
     */
    public void solicitudDevolucion(Devoluciones devoluciones);

    /**
     * Obtiene una lista paginada de devoluciones.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de devoluciones.
     */
    public Page<Devoluciones> listarDevolucionesPaginado(Pageable pageable);
}
