package com.sistema.regisstro.Sistemademo.Service.Ecommerce.SalesTicket;

import com.sistema.regisstro.Sistemademo.Entity.Pedido;

import java.time.LocalDateTime;

public interface ServicioBoletas {

    //generar boleta segun usuario de Sesion actual
    Pedido generarboleta(int novoST, LocalDateTime fecha);
}
