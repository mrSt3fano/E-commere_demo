package com.sistema.regisstro.Sistemademo.AccessDB.SpringREST;

import com.sistema.regisstro.Sistemademo.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoData extends JpaRepository<Productos,Integer> {
}
