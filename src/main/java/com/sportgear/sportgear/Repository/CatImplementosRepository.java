package com.sportgear.sportgear.Repository;

import com.sportgear.sportgear.Model.CatImplementos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatImplementosRepository extends JpaRepository<CatImplementos,Long> {
}
