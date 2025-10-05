package com.sistema.regisstro.Sistemademo.Controller.CRUD;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.Usuario.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CEliminar {

    Servicio ss;

    @Autowired
    public CEliminar(Servicio ss) {
        this.ss = ss;
    }

    @PostMapping("/eliminar/{usuario}")
    public String eliminar(@PathVariable String usuario){
        Usuario use=ss.encontrarUsuarioAhora(usuario);
        ss.borrarusuario(use);
        return "/Alter/eliminar-confirmacion";
    }
}
