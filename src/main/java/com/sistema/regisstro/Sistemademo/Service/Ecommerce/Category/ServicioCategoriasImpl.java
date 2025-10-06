package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Category;

import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.CategoriaData;
import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.ProductoData;
import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.DTO.WebCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCategoriasImpl implements ServicioCategorias{

    private CategoriaData cat;
    private ProductoData prov;

    @Autowired
    public ServicioCategoriasImpl(CategoriaData cat, ProductoData prov) {
        this.cat = cat;
        this.prov = prov;
    }

    @Override
    public Categorias consultaCategoriaID(int vats) {
        Optional<Categorias> resultado = cat.findById(vats);
        Categorias c =null;
        if(resultado.isPresent()){
            c=resultado.get();
        }
        else{
            throw new RuntimeException("No se pudo encontrar por el id: "+vats);
        }

        return c;
    }

    @Override
    public List<Categorias> consultaCategorias() {
        return cat.findAll();
    }

    @Override
    public Categorias guardarCategorias(WebCategory novoCatg) {

        Categorias cc=new Categorias();

        cc.setNombre(novoCatg.getCategoria());
        cc.setDescripcion(novoCatg.getDescripcion());

        cat.save(cc);
        return cc;
    }

    @Override
    public Categorias actualizarCategoria(Categorias actual, WebCategory novo) {

        actual.setNombre(novo.getCategoria());
        actual.setDescripcion(novo.getDescripcion());
        cat.save(actual);
        return actual;
    }

    @Override
    public void borrarCategoria(Categorias catg) {
        cat.delete(catg);
    }

    @Override
    public List<Productos> consultarProductos(int actual) {

        Optional<Categorias> resultado = cat.findById(actual);
        Categorias c =null;
        if(resultado.isPresent()){
            c=resultado.get();
        }
        else{
            throw new RuntimeException("No se pudo encontrar por el id: "+actual);
        }

        return c.getProductosList();
//        return  prov.findAll();
    }
}
