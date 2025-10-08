package com.sistema.regisstro.Sistemademo.Controller.CRUD;

import com.sistema.regisstro.Sistemademo.DTO.WebCategory;
import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Entity.Roles;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Category.ServicioCategorias;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Product.ServicioProductos;
import com.sistema.regisstro.Sistemademo.Service.Usuario.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CConsultas {

    private Servicio ser;
    private ServicioCategorias serv;
    private ServicioProductos prod;

    @Autowired
    public CConsultas(Servicio ser, ServicioCategorias serv, ServicioProductos p) {
        this.ser = ser;
        this.serv = serv;
        this.prod=p;
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

    @GetMapping("/consultarcategoriauna")
    public String safasfa(Model mo){
        List<Categorias>catt=serv.consultaCategorias();
        mo.addAttribute("numero",new WebCategory());
        mo.addAttribute("categoria",catt);
        return "/seleccionarCat";
    }

    @GetMapping("/consultarCategoriaProduct")
    public String mostrarproductosporcategoria(Model mo , @ModelAttribute WebCategory s){
        List<Productos>catt=serv.consultarProductos(s.getNumb());
        mo.addAttribute("productbycat",catt);
        return "/Gerency/consultasDeAdmin";
    }

    @GetMapping("/consultarproductos")
    public String mostrarproductosentotal(Model mo){
        List<Productos> procc=prod.consultaProductos();
        mo.addAttribute("productosconsulta",procc);
        return "/Gerency/consultasDeAdmin";
    }



}
