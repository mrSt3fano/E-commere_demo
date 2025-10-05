package com.sistema.regisstro.Sistemademo.AccessDB.SpringREST;

import com.sistema.regisstro.Sistemademo.Entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedoresData extends JpaRepository<Proveedores,Integer> {
}
