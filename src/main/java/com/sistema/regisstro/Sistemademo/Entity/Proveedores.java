package com.sistema.regisstro.Sistemademo.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proveedor")
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_company")
    private String compania;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "número")
    private String numero;

    @Column(name = "tipo_producto")
    private String tipoDEproducto;

    //relacion con productos
//    @OneToMany(mappedBy = "prov",cascade = {CascadeType.DETACH,CascadeType.MERGE,
//            CascadeType.PERSIST,CascadeType.REFRESH})
//    private List<Productos> productosProv;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "prod_prov",
            joinColumns = @JoinColumn(name = "id_prov"),
            inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<Productos> productosProv;


    public Proveedores() {
    }

    public Proveedores(String nombre, String compania, String direccion, String ciudad, String numero, String tipoDEproducto) {
        this.nombre = nombre;
        this.compania = compania;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.numero = numero;
        this.tipoDEproducto = tipoDEproducto;
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

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoDEproducto() {
        return tipoDEproducto;
    }

    public void setTipoDEproducto(String tipoDEproducto) {
        this.tipoDEproducto = tipoDEproducto;
    }

    public List<Productos> getProductosProv() {
        return productosProv;
    }

    public void setProductosProv(List<Productos> productosProv) {
        this.productosProv = productosProv;
    }

    public void añadirprod_prove(Productos p){
        if(productosProv ==null){
            productosProv =new ArrayList<>();
        }
        productosProv.add(p);//añadir producto a la lista de productos
        p.agregarproveedor(this);//añadir lista a proveedor
    }

    @Override
    public String toString() {
        return "Proveedores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compania='" + compania + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", numero='" + numero + '\'' +
                ", tipoDEproducto='" + tipoDEproducto + '\'' +
                '}';
    }
}
