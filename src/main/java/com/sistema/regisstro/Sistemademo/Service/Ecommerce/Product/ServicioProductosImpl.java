package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Product;

import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.CategoriaData;
import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.ProductoData;
import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Entity.Proveedores;
import com.sistema.regisstro.Sistemademo.Entity.Ventas;
import com.sistema.regisstro.Sistemademo.DTO.WebProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProductosImpl implements ServicioProductos {

    private ProductoData p;
    private CategoriaData ct;

    @Autowired
    public ServicioProductosImpl(ProductoData p, CategoriaData v) {
        this.p = p;
        this.ct = v;
    }

    @Override
    public Productos consultaProductoID(int prod) {
        Optional<Productos> resultado = p.findById(prod);
        Productos c =null;
        if(resultado.isPresent()){
            c=resultado.get();
        }
        else{
            throw new RuntimeException("No se pudo encontrar por el id: "+prod);
        }
        return c;
    }

    @Override
    public List<Productos> consultaProductos(int ide) {

        Optional<Categorias> res2 = ct.findById(ide);
        Categorias c =null;
        if(res2.isPresent()){
            c=res2.get();
        }
        else{
            throw new RuntimeException("No se pudo encontrar los productos por el id categoria: "+ide);
        }

        if(c.getId()==ide){
            Productos productos=new Productos();
            c.añadirproductos_categ(productos);
            p.findAll();
        }
        return p.findAll();
    }

    @Override
    public List<Productos> consultaProductos(){
        return p.findAll();
    }


    @Override
    public Productos guardarProductos(WebProduct novoProdc) {

        Productos pp=new Productos();
        pp.setNombre(novoProdc.getNombre());
        pp.setMarca(novoProdc.getMarca());
        pp.setPrecio(novoProdc.getPrecio());
        pp.setStock(novoProdc.getStock());
        pp.setCat(novoProdc.getCategoria());

        p.save(pp);
        return pp;
    }

    @Override
    public Productos actualizarProducto(Productos actual, WebProduct novo) {

        actual.setNombre(novo.getNombre());
        return null;
    }

    @Override
    public void borrarProducto(Productos catg) {

    }

    @Override
    public List<Ventas> consultarVentas() {
        return List.of();
    }


    @Override
    public List<Proveedores> consultarProveedores(int actual) {

        Optional<Productos> resultado = p.findById(actual);
        Productos c =null;
        if(resultado.isPresent()){
            c=resultado.get();
        }
        else{
            throw new RuntimeException("No se pudo encontrar por el id: "+actual);
        }

        return c.getProv();


    }
}
