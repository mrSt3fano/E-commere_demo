package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Product;

import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Entity.Proveedores;
import com.sistema.regisstro.Sistemademo.Entity.Ventas;
import com.sistema.regisstro.Sistemademo.DTO.WebProduct;

import java.util.List;

public interface ServicioProductos {
    Productos consultaProductoID(int prod);
    List<Productos> consultaProductos(int ide);
    List<Productos> consultaProductos();
    Productos guardarProductos(WebProduct novoProdc);
    Productos actualizarProducto(Productos actual, WebProduct novo);
    void borrarProducto(Productos catg);
    List<Ventas> consultarVentas();
    public List<Proveedores> consultarProveedores(int actual);
}
