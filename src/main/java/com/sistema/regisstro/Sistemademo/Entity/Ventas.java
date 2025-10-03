package com.sistema.regisstro.Sistemademo.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venta")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_venta")
    private float precioventa;

    //relacion con boleta
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_boleta")
    private Boleta bol;

    //relacion con productos
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "tabla_intermedia",
            joinColumns = @JoinColumn(name = "id_venta"),
            inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<Productos> prodc;

    public Ventas() {
    }

    public Ventas(int cantidad, float precioventa) {
        this.cantidad = cantidad;
        this.precioventa = precioventa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Boleta getBol() {
        return bol;
    }

    public void setBol(Boleta bol) {
        this.bol = bol;
    }

    public List<Productos> getProdc() {
        return prodc;
    }

    public void setProdc(List<Productos> prodc) {
        this.prodc = prodc;
    }

    public void agregarprodc(Productos p){
        if(prodc==null){
            prodc=new ArrayList<>();
        }
        prodc.add(p);
        p.agregarventa(this);
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
