package com.sistema.regisstro.Sistemademo.DTO;

import com.sistema.regisstro.Sistemademo.Entity.Categorias;

public class WebProduct {

    private String nombre;

    private Double precio;

    private String marca;

    private Integer stock;

    private Categorias categoria;

    public WebProduct() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }
}
