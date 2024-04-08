package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<Estado,Long> {
}
