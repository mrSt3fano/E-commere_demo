package com.sistema.regisstro.Sistemademo.AccessDB.SpringREST;

import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaData extends JpaRepository<Categorias,Integer> {
}
