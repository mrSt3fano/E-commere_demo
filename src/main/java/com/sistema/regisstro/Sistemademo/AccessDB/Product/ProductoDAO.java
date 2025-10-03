package com.sistema.regisstro.Sistemademo.AccessDB.Product;

import com.sistema.regisstro.Sistemademo.Entity.Productos;

import java.util.List;

public interface ProductoDAO {
    Productos encontrarProductosActual(String a);
    void guardaruser(Productos afg);
    List<Productos> encontrarProductoss();
    void eliminarProductos(Productos u);
    Productos actualizarProductos(Productos act);
}
