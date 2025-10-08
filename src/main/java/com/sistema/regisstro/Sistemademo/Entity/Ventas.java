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
    private Integer cantidad;

    @Column(name = "precio_venta")
    private Double precioventa;

    @Column(name="orden")
    private String orden;

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

    public Ventas(Integer cantidad, Double precioventa, String orden) {
        this.cantidad = cantidad;
        this.precioventa = precioventa;
        this.orden=orden;
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

    public String getOrden() { return orden; }

    public void setOrden(String orden) { this.orden = orden; }

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
                ", orden='" + orden + '\'' +
                '}';
    }
}
