package com.sistema.regisstro.Sistemademo.Controller.CRUD;


import com.sistema.regisstro.Sistemademo.DTO.WebUser;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.Usuario.Servicio;
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

    Servicio e;

    @Autowired
    public CActualizar(Servicio e) {
        this.e = e;
    }

    @PostMapping("/forms/{usuario}")
    public String fomrs(@PathVariable String usuario,Model mo){
        Usuario use=e.encontrarUsuarioAhora(usuario);
        WebUser web= new WebUser();
        mo.addAttribute("usuarioactual",use);
        mo.addAttribute("usuarionuevo",web);
        return "/Alter/actualizar-forms";
    }

    @PostMapping("/confirmacion/{usuario}")
    public String actualizar(@PathVariable String usuario,
                             @Valid @ModelAttribute("usuarionuevo")
                             WebUser nuevo, Model mo){
        Usuario nn=e.encontrarUsuarioAhora(usuario);
        Usuario mus=e.actualizarusuario(nn,nuevo);
        mo.addAttribute("useractualizado",mus);
        return "/Alter/actualizar-confirmacion";
    }

}
