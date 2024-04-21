package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.Devoluciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucionRepository extends JpaRepository<Devoluciones, Long> {
}
