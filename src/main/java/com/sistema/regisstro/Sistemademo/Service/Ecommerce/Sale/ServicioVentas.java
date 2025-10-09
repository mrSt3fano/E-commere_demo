package com.sistema.regisstro.Sistemademo.Service.Ecommerce.Sale;

import com.sistema.regisstro.Sistemademo.Entity.Boleta;
import com.sistema.regisstro.Sistemademo.Entity.Ventas;

import java.time.LocalDateTime;

public interface ServicioVentas {

    Ventas generarventas(Boleta novoboleta, int cantidad, String orden);
}
