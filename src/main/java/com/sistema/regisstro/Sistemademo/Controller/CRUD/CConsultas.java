package com.sistema.regisstro.Sistemademo.Controller.CRUD;

import com.sistema.regisstro.Sistemademo.Entity.Roles;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CConsultas {

    private ServicioUsuario ser;

    @Autowired
    public CConsultas(ServicioUsuario ser) {
        this.ser = ser;
    }

    @GetMapping("/consultas")
    public String mostrarconsultas(Model mo) {
        List<Usuario>uss = ser.consultausuarios();
        List<Roles> rols=ser.consultarroles();
        mo.addAttribute("conss", uss);
        mo.addAttribute("roles",rols);
        return "/Gerency/consultasDeAdmin";
    }
}
