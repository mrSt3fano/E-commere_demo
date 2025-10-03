package com.sistema.regisstro.Sistemademo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CEnrutamiento {

    @GetMapping("/")
    public String inicio(){
        return "/Home/home";
    }

    @GetMapping("/socio")
    public String socios(){
        return "/Partners/socios";
    }

    @GetMapping("/gerencia")
    public String admins(){
        return "/Gerency/gerencia";
    }
}
