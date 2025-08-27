package com.sistema.regisstro.Sistemademo.Controlador.CRUD;


import com.sistema.regisstro.Sistemademo.AccesoDatos.DatosEcommerce.WebUser;
import com.sistema.regisstro.Sistemademo.Entidades.Usuario;
import com.sistema.regisstro.Sistemademo.Servicio.ServicioUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actualizar")
public class CActualizar {

    ServicioUsuario e;

    @Autowired
    public CActualizar(ServicioUsuario e) {
        this.e = e;
    }

    @PostMapping("/forms/{usuario}")
    public String fomrs(@PathVariable String usuario,Model mo){
        Usuario use=e.encontrarporid(usuario);
        WebUser web= new WebUser();
        mo.addAttribute("usuarioactual",use);
        mo.addAttribute("usuarionuevo",web);
        return "/Alter/actualizar-forms";
    }

    @PostMapping("/confirmacion/{usuario}")
    public String actualizar(@PathVariable String usuario,
                             @Valid @ModelAttribute("usuarionuevo")
                             WebUser nuevo, Model mo){
        Usuario nn=e.encontrarporid(usuario);
        Usuario mus=e.actualizarusuario(nn,nuevo);
        mo.addAttribute("useractualizado",mus);
        return "/Alter/actualizar-confirmacion";
    }

}
