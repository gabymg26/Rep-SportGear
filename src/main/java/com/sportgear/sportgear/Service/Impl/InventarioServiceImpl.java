package com.sportgear.sportgear.Service.Impl;

import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Repository.InventarioRepository;
import com.sportgear.sportgear.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Implementación del servicio para la gestión de inventario.
 */
@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    /**
     * Obtiene una lista de todo el inventario.
     *
     * @return Lista de inventario.
     */
    @Override
    public List<Inventario> listarInventario() {return (List<Inventario>) inventarioRepository.findAll();}

    /**
     * Obtiene una lista paginada de inventario.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de inventario.
     */
    public Page<Inventario> listarInventarioPaginado(Pageable pageable) {
        return inventarioRepository.findAll(pageable);
    }

    /**
     * Guarda un objeto Inventario en la base de datos.
     *
     * @param inventario Objeto Inventario a guardar.
     */
    @Override
    public void guardar(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    /**
     * Busca un objeto Inventario por su ID.
     *
     * @param id ID del Inventario a buscar.
     * @return Objeto Inventario encontrado, o null si no se encuentra.
     */
    @Override
    public Inventario buscarPorId(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un objeto Inventario de la base de datos.
     *
     * @param id ID del Inventario a eliminar.
     */
    @Override
    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }

}
