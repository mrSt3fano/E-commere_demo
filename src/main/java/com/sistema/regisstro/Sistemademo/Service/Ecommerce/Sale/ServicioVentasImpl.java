package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Sale;

import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.BoletaData;
import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.VentasData;
import com.sistema.regisstro.Sistemademo.Entity.Boleta;
import com.sistema.regisstro.Sistemademo.Entity.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioVentasImpl implements ServicioVentas {

    private VentasData generarFinal;

    @Autowired
    public ServicioVentasImpl(VentasData generarFinal) {
        this.generarFinal = generarFinal;
    }


    @Override
    public Ventas generarventas(Boleta novoboleta, int cantidad, String orden) {
        Ventas ventas=new Ventas();
        ventas.setBol(novoboleta);
        ventas.setCantidad(cantidad);
        ventas.setOrden(orden);
        ventas.setPrecioventa(1.1);

        generarFinal.save(ventas);
        return ventas;
    }
}
