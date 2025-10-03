package com.sistema.regisstro.Sistemademo.Controller.CRUD;

import java.util.logging.Logger;

import com.sistema.regisstro.Sistemademo.Incoming.WebUser;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.ServicioUsuario;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registrar")
public class CRegistro {

    private Logger log = Logger.getLogger(getClass().getName());
    private ServicioUsuario serv;

    @Autowired
    public CRegistro(ServicioUsuario serv) {
        this.serv = serv;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/nuevoUsuario")
    public String showMyLoginPage(Model mo) {
        mo.addAttribute("webUser", new WebUser());
        return "/Login-SignUp/registro-usuario";
    }


    @PostMapping("/procesoRegistracion")
    public String processRegistrationForm(
            @Valid @ModelAttribute("webUser") WebUser nuevo,
            BindingResult theBindingResult,
            HttpSession session, Model theModel)
    {
        String nuevousuario = nuevo.getNombre();
        log.info("Procesando registro para: " + nuevousuario);

        if (theBindingResult.hasErrors()){
            return "/Login-SignUp/registro-usuario";}

        //verificar si el usuario existe
        Usuario existing = serv.encontrarUsuarioAhora(nuevousuario);
        if (existing != null){
            theModel.addAttribute("webUser", new WebUser());
            theModel.addAttribute("registrationError", "El usuario ya existe.");

            log.warning("Nombre de usuario ya existe");
            return "/Login-SignUp/registro-usuario";
        }

        //guardar usuario en la base de datos
        Usuario asd=serv.guardarUsuario(nuevo);

        log.info("Usuario creado satisfactoriamente: " + nuevousuario);

        // place user in the web http session for later use
        session.setAttribute("user", nuevo);
        theModel.addAttribute("usuarioregistrado",asd);

        return "/Login-SignUp/registro-confirmacion";
    }
}
