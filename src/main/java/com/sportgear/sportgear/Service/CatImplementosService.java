package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.CatImplementos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interfaz que define los métodos para el servicio de gestión de categorías de implementos.
 */
public interface CatImplementosService {

    /**
     * Obtiene una lista de todas las categorías de implementos.
     *
     * @return Lista de categorías de implementos.
     */
    List<CatImplementos> listarCategorias();

    /**
     * Guarda una nueva categoría de implementos en la base de datos.
     *
     * @param catImplementos Objeto CatImplementos que representa la categoría a guardar.
     */
    public void guadar_categoria(CatImplementos catImplementos);

    /**
     * Obtiene una lista paginada de categorías de implementos.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de categorías de implementos.
     */
    public Page<CatImplementos> listarCategoriasPaginado(Pageable pageable);
}
