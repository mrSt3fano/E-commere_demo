package com.sistema.regisstro.Sistemademo.Incoming;

import java.time.LocalDateTime;

public class WebSalesTicket {

    private LocalDateTime fechaActual;

    public WebSalesTicket() {
    }

    public LocalDateTime getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDateTime fechaActual) {
        this.fechaActual = fechaActual;
    }
}
