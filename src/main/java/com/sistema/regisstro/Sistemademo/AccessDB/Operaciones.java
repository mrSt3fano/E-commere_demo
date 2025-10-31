package com.sistema.regisstro.Sistemademo.AccessDB;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Operaciones extends JpaRepository<Usuario,Integer> {


    @Query("SELECT b.fecha, p.nombre as producto,ca.nombre as categoria," +
            "p.precio as precio_unitario,v.cantidad, pv.ciudad, pv.nombre as vendedor"+
            " FROM Usuario u " +
            " JOIN u.pedido b " +
            " JOIN b.ventasList v " +
            " JOIN v.prod2 p"+
            " JOIN p.prov pv"+
            " JOIN p.cat ca " +
            " ORDER BY b.fecha ASC")
    List<Object[]> obtenerConsultasGenerales();

}