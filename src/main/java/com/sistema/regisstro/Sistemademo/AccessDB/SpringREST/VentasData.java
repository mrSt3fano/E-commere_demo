package com.sistema.regisstro.Sistemademo.AccessDB.SpringREST;

import com.sistema.regisstro.Sistemademo.Entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasData extends JpaRepository<Ventas,Integer> {
}
