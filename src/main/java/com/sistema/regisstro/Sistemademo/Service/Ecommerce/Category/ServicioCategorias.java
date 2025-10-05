package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Category;

import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Incoming.WebCategory;

import java.util.List;

public interface ServicioCategorias {
    Categorias consultaCategoriaID(int cat);
    List<Categorias> consultaCategorias();
    Categorias guardarCategorias(WebCategory novoCatg);
    Categorias actualizarCategoria(Categorias actual, WebCategory novo);
    void borrarCategoria(Categorias catg);
    List<Productos> consultarProductos(int actual);
}
