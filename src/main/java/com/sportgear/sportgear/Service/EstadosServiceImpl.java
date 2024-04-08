package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Estado;
import com.sportgear.sportgear.Repository.EstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadosServiceImpl implements EstadosService{

     @Autowired
     private EstadosRepository estadosRepository;

    @Override
    public List<Estado> listarEstados() {
        return (List<Estado>) estadosRepository.findAll();
    }
}
