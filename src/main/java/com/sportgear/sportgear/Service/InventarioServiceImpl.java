package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Inventario;
import com.sportgear.sportgear.Repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService{

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> listarInventario() {
        return (List<Inventario>) inventarioRepository.findAll() ;
    }

    @Override
    public void guardar(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    @Override
    public Inventario buscarPorId(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }
}
