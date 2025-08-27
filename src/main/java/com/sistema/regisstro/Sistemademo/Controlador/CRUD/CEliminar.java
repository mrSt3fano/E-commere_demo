package com.sistema.regisstro.Sistemademo.Controlador.CRUD;

import com.sistema.regisstro.Sistemademo.Entidades.Usuario;
import com.sistema.regisstro.Sistemademo.Servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CEliminar {

    ServicioUsuario ss;

    @Autowired
    public CEliminar(ServicioUsuario ss) {
        this.ss = ss;
    }

    @PostMapping("/eliminar/{usuario}")
    public String eliminar(@PathVariable String usuario){
        Usuario use=ss.encontrarporid(usuario);
        ss.borrarusuario(use);
        return "/Alter/eliminar-confirmacion";
    }
}
