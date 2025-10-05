package com.sistema.regisstro.Sistemademo.Incoming;

public class WebSale {

    private int cantidad;

    private float precioventa;

    private String orden;

    public WebSale() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    public String getOrden() { return orden; }

    public void setOrden(String orden) { this.orden = orden; }
}
