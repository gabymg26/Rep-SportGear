package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.CatImplementos;

import java.util.List;

public interface CatImplementosService {

    List<CatImplementos> listarCategorias();

    public void guadar_categoria(CatImplementos catImplementos);

    public CatImplementos buscarPorId(Long id);

    public void eliminar(Long id);

}
