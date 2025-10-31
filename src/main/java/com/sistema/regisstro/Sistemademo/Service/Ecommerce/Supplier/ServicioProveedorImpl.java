package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Supplier;

import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.ProveedoresData;
import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioProveedorImpl implements SevicioProveedor{

    private ProveedoresData pd;

    @Autowired
    public ServicioProveedorImpl(ProveedoresData pd) {
        this.pd = pd;
    }


    @Override
    public Proveedores consultaProveedoresID(int prod) {

        Optional<Proveedores> resultado = pd.findById(prod);
        Proveedores c =null;
        if(resultado.isPresent()){
            c=resultado.get();
        }
        else{
            throw new RuntimeException("No se pudo encontrar por el id: "+prod);
        }

        return c;

    }
}
