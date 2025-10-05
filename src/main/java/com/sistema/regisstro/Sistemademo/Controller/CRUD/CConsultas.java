package com.sistema.regisstro.Sistemademo.Controller.CRUD;

import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Entity.Roles;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Category.ServicioCategorias;
import com.sistema.regisstro.Sistemademo.Service.Usuario.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CConsultas {

    private Servicio ser;
    private ServicioCategorias serv;

    @Autowired
    public CConsultas(Servicio ser, ServicioCategorias serv) {
        this.ser = ser;
        this.serv = serv;
    }

    @GetMapping("/consultas")
    public String mostrarconsultas(Model mo) {
        List<Usuario>uss = ser.consultausuarios();
        List<Roles> rols=ser.consultarroles();
        mo.addAttribute("conss", uss);
        mo.addAttribute("roles",rols);
        return "/Gerency/consultasDeAdmin";
    }

    @GetMapping("/consultarCategoria")
    public String mostrartodaslascategorias(Model mo){
        List<Categorias>catt=serv.consultaCategorias();
        mo.addAttribute("aea",catt);
        return "/Gerency/consultasDeAdmin";
    }

    @GetMapping("/consultarCategoriaProduct")
    public String mostrarproductosporcategoria(Model mo){
        List<Productos>catt=serv.consultarProductos(6);
        mo.addAttribute("productos",catt);
        return "/Gerency/consultasDeAdmin";
    }

}
