package com.sportgear.sportgear.Service;

import com.sportgear.sportgear.Model.Inventario;

import java.util.List;

public interface InventarioService {

    public List<Inventario> listarInventario();
    public void guardar(Inventario inventario);
    public Inventario buscarPorId(Long id);
    public void eliminar(Long id);
}
