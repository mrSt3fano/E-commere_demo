package com.sistema.regisstro.Sistemademo.AccessDB;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Operaciones extends JpaRepository<Usuario,Integer> {

// Asume que Usuario tiene una lista de Boletas (u.boletas)
// Asume que Boleta tiene una lista de Ventas (b.ventas)
// Asume que Venta está relacionada con Producto (v.producto)

    @Query("SELECT u.nombre AS nombre_de_usuario, " +
            "       b.fecha, v.orden, v.cantidad, v.precioventa AS precio_final, " +
            "       p.nombre AS nombre_producto, p.marca, p.precio AS precio_unitario " +
            "FROM Usuario u " +
            "JOIN u.boleta b " + // Navega a través de la relación definida en Usuario
            "JOIN b.ventasList v " +  // Navega a través de la relación definida en Boleta
            "JOIN v.prodc p")  // Navega a través de la relación definida en Venta
    List<Object[]> obtenerConsultasGenerales();

}