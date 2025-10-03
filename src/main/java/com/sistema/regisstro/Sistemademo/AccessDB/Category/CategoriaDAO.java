package com.sistema.regisstro.Sistemademo.AccessDB.Category;

import com.sistema.regisstro.Sistemademo.Entity.Categorias;

import java.util.List;

public interface CategoriaDAO {
    Categorias encontrarCategoriactual(String vars);
    void guardarCategoria(Categorias cat);
    List<Categorias> encontrarCategoria();
    void eliminarCategoria(Categorias cat);
    Categorias actualizarCategoria(Categorias cat);
}
