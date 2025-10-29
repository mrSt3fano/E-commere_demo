package com.sistema.regisstro.Sistemademo.Service.Ecommerce.SalesTicket;

import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.BoletaData;
import com.sistema.regisstro.Sistemademo.Entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicioBoletasImpl implements ServicioBoletas{

    private BoletaData generar;

    @Autowired
    public ServicioBoletasImpl(BoletaData safas) {
        this.generar = safas;
    }

    @Override
    public Pedido generarboleta(int novoST, LocalDateTime fecha) {
        Pedido pedido =new Pedido();
        pedido.setId(novoST);
        pedido.setFecha(fecha);

        generar.save(pedido);
        return pedido;
    }
}
