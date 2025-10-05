package com.sistema.regisstro.Sistemademo.AccessDB.SpringREST;

import com.sistema.regisstro.Sistemademo.Entity.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletaData extends JpaRepository<Boleta,Integer> {
}
