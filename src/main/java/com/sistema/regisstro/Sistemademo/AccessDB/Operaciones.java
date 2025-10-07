package com.sistema.regisstro.Sistemademo.AccessDB;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Operaciones extends JpaRepository<Usuario,Integer> {


    @Query("SELECT u.nombre AS Usuario, \n" +
            "       b.fecha, v.orden, v.cantidad,p.precio as precio_unitario, \n" +
            "       (p.precio * v.cantidad) as precio_final,\n" +
            "p.nombre as nombre_producto,ca.nombre as categoria, ca.descripcion,\n" +
            "p.marca, pv.tipoDEproducto,\n" +
            "pv.nombre as nombre_proveedor, pv.ciudad as ciudad, pv.compania\n" +
            "as nombre_compañia, pv.numero as telefono\n"+
            " FROM Usuario u " +
            " JOIN u.boleta b " +
            " JOIN b.ventasList v " +
            " JOIN v.prodc p"+
            " JOIN p.prov pv"+
            " JOIN p.cat ca ")  // Navega a través de la relación definida en Venta
    List<Object[]> obtenerConsultasGenerales();


}