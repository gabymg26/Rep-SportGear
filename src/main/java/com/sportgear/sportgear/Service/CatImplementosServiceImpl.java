package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.CatImplementos;
import com.sportgear.sportgear.Repository.CatImplementosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatImplementosServiceImpl implements CatImplementosService{

    @Autowired
    private CatImplementosRepository catImplementosRepository;

    @Override
    public List<CatImplementos> listarCategorias() {
        return (List<CatImplementos>) catImplementosRepository.findAll();
    }

    @Override
    public void guadar_categoria(CatImplementos catImplementos) {
        catImplementosRepository.save(catImplementos);
    }

    @Override
    public CatImplementos buscarPorId(Long id) {
        return catImplementosRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        catImplementosRepository.deleteById(id);
    }
}
