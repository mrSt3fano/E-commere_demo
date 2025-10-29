package com.sistema.regisstro.Sistemademo.DTO;

import java.time.LocalDateTime;

public class WebOrder {

    private LocalDateTime fechaActual;

    private Integer orden;

    public WebOrder() {
    }

    public LocalDateTime getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDateTime fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
