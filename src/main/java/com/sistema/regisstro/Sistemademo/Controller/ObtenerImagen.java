package com.sistema.regisstro.Sistemademo.Controller;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ObtenerImagen {

    ServicioUsuario servicioUsuario;

    @Autowired
    public ObtenerImagen(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/usuario/imagen/{nombre}")
    @ResponseBody
    public ResponseEntity<byte[]> mostrarImagen(@PathVariable String nombre) {


        Usuario u = servicioUsuario.encontrarUsuarioAhora(nombre);
        byte[] imagen = u.getImagen();

        if (u == null || u.getImagen() == null) {
            return null;
        }

        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg")
                .body(imagen);

    }

}
