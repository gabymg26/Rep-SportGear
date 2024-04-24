package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Inventario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Interfaz que define los métodos para el servicio de gestión de inventario.
 */
public interface InventarioService {

    /**
     * Obtiene una lista de todo el inventario.
     *
     * @return Lista de inventario.
     */
    public List<Inventario> listarInventario();

    /**
     * Guarda un objeto Inventario en la base de datos.
     *
     * @param inventario Objeto Inventario a guardar.
     */
    public void guardar(Inventario inventario);

    /**
     * Busca un objeto Inventario por su ID.
     *
     * @param id ID del Inventario a buscar.
     * @return Objeto Inventario encontrado, o null si no se encuentra.
     */
    public Inventario buscarPorId(Long id);

    /**
     * Elimina un objeto Inventario de la base de datos.
     *
     * @param id ID del Inventario a eliminar.
     */
    public void eliminar(Long id);

    /**
     * Obtiene una lista paginada de inventario.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de inventario.
     */
    public Page<Inventario> listarInventarioPaginado(Pageable pageable);
}
