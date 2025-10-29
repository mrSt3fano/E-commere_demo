package com.sistema.regisstro.Sistemademo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_venta")
    private Double precioventa;


    //relacion con pedido
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    //relacion con productos
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_producto")
    private Productos prod2;


    public Ventas() {
    }

    public Ventas(Integer cantidad, Double precioventa) {
        this.cantidad = cantidad;
        this.precioventa = precioventa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Productos getProd2() {
        return prod2;
    }

    public void setProd2(Productos prod2) {
        this.prod2 = prod2;
    }



    @Override
    public String toString() {
        return "Ventas{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioventa=" + precioventa +
                '}';
    }
}
