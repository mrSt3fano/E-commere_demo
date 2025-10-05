package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Product;

import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Entity.Ventas;
import com.sistema.regisstro.Sistemademo.Incoming.WebProduct;

import java.util.List;

public interface ServicioProductos {
    Productos consultaProductoID(int prod);
    List<Productos> consultaProductos(int ide);
    Productos guardarProductos(WebProduct novoProdc);
    Productos actualizarProducto(Productos actual, WebProduct novo);
    void borrarProducto(Productos catg);
    List<Ventas> consultarVentas();
}
