package com.sistema.regisstro.Sistemademo.DTO;

public class WebSale {

    private Integer cantidad;

    private Double precioventa;

    private String orden;

    public WebSale() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public String getOrden() { return orden; }

    public void setOrden(String orden) { this.orden = orden; }
}
