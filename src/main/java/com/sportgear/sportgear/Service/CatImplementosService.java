package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.CatImplementos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CatImplementosService {

    List<CatImplementos> listarCategorias();

    public void guadar_categoria(CatImplementos catImplementos);

    public Page<CatImplementos> listarCategoriasPaginado(Pageable pageable);
}
