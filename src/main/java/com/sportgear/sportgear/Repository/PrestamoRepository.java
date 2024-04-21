package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamos, Long> {
}
