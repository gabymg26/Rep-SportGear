package com.sportgear.sportgear.Service.Impl;

import com.sportgear.sportgear.Model.CatImplementos;
import com.sportgear.sportgear.Repository.CatImplementosRepository;
import com.sportgear.sportgear.Service.CatImplementosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para la gestión de categorías de implementos.
 */
@Service
public class CatImplementosServiceImpl implements CatImplementosService {

    @Autowired
    private CatImplementosRepository catImplementosRepository;

    /**
     * Obtiene una lista de todas las categorías de implementos.
     *
     * @return Lista de categorías de implementos.
     */
    @Override
    public List<CatImplementos> listarCategorias() {
        return (List<CatImplementos>) catImplementosRepository.findAll();
    }

    /**
     * Guarda una nueva categoría de implementos en la base de datos.
     *
     * @param catImplementos Objeto CatImplementos que representa la categoría a guardar.
     */
    @Override
    public void guadar_categoria(CatImplementos catImplementos) {
        catImplementosRepository.save(catImplementos);
    }

    /**
     * Obtiene una lista paginada de categorías de implementos.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de categorías de implementos.
     */
    @Override
    public Page<CatImplementos> listarCategoriasPaginado(Pageable pageable) {
        return catImplementosRepository.findAll(pageable);
    }

}
