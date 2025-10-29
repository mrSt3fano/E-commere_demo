package com.sistema.regisstro.Sistemademo.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido_usuario")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name="orden")
    private Integer orden;

    //relacion con usuarios
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private Usuario us;

    //relacion con ventas
    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Ventas>ventasList;

    public Pedido() {
    }

    public Pedido(LocalDateTime fecha, Integer orden) {
        this.fecha = fecha;
        this.orden=orden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public void añadirventa(Ventas v){
        if(ventasList==null){
            ventasList=new ArrayList<>();
        }
        ventasList.add(v);
        v.setPedido(this);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", orden=" + orden +
                ", id=" + id +
                '}';
    }
}
