package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Sale;

import com.sistema.regisstro.Sistemademo.Entity.Pedido;
import com.sistema.regisstro.Sistemademo.Entity.Ventas;

public interface ServicioVentas {

    Ventas generarventas(Pedido novoboleta, int cantidad);
}
