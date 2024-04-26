package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.CatImplementos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos para acceder y manipular datos de categorías de implementos en la base de datos.
 */
@Repository
public interface CatImplementosRepository extends JpaRepository<CatImplementos,Long> {
}
