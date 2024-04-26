package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Prestamos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interfaz que define los métodos para el servicio de gestión de préstamos.
 */
public interface PrestamosService {


    /**
     * Obtiene una lista de todos los préstamos.
     *
     * @return Lista de préstamos.
     */
    List<Prestamos> listarPrestamos();


    /**
     * Registra una solicitud de préstamo.
     *
     * @param prestamos Objeto Prestamos que representa la solicitud de préstamo.
     */
    public void solicitudPrestamo(Prestamos prestamos);


    /**
     * Obtiene una lista paginada de préstamos.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de préstamos.
     */
    public Page<Prestamos> listarPrestamosPaginado(Pageable pageable);
}
