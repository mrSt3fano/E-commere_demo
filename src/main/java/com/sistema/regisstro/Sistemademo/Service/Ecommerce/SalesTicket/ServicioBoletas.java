package com.sistema.regisstro.Sistemademo.Service.Ecommerce.SalesTicket;

import com.sistema.regisstro.Sistemademo.DTO.WebProduct;
import com.sistema.regisstro.Sistemademo.DTO.WebSalesTicket;
import com.sistema.regisstro.Sistemademo.Entity.Boleta;
import com.sistema.regisstro.Sistemademo.Entity.Productos;

import java.time.LocalDateTime;

public interface ServicioBoletas {

    //generar boleta segun usuario de Sesion actual
    Boleta generarboleta(int novoST, LocalDateTime fecha);
}
