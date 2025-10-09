package com.sistema.regisstro.Sistemademo.Service.Ecommerce.SalesTicket;

import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.BoletaData;
import com.sistema.regisstro.Sistemademo.DTO.WebSalesTicket;
import com.sistema.regisstro.Sistemademo.Entity.Boleta;
import com.sistema.regisstro.Sistemademo.Service.Usuario.Servicio;
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
    public Boleta generarboleta(int novoST, LocalDateTime fecha) {
        Boleta boleta=new Boleta();
        boleta.setId(novoST);
        boleta.setFecha(fecha);

        generar.save(boleta);
        return boleta;
    }
}
