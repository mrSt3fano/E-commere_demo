package com.sistema.regisstro.Sistemademo.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "marca")
    private String marca;

    @Column(name = "stock")
    private Integer stock;

    //relacion con categorias
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_categoria")
    private Categorias cat;

    //relacion con proveedores
//    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
//            CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinColumn(name = "id_proveedor")
//    private Proveedores prov;
    @ManyToMany(mappedBy = "productosProv", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Proveedores> prov;


    //relacion con ventas
    @ManyToMany(mappedBy = "prodc", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Ventas> vent;

    public Productos() {
    }

    public Productos(String nombre, Double precio, String marca, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Categorias getCat() {
        return cat;
    }

    public void setCat(Categorias cat) {
        this.cat = cat;
    }

    public List<Proveedores> getProv() {
        return prov;
    }

    public void setProv(List<Proveedores> prov) {
        this.prov = prov;
    }

    public List<Ventas> getVent() {
        return vent;
    }

    public void setVent(List<Ventas> vent) {
        this.vent = vent;
    }

    public void agregarventa(Ventas vv){
        if(vent==null){
            vent=new ArrayList<>();
        }
        vent.add(vv);
        vv.agregarprodc(this);
    }

    public void agregarproveedor(Proveedores pp){
        if(prov==null){
            prov=new ArrayList<>();
        }
        prov.add(pp);
        pp.añadirprod_prove(this);
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", stock=" + stock +
                '}';
    }
}
