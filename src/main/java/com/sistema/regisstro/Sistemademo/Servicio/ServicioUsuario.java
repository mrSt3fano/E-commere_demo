package com.sistema.regisstro.Sistemademo.Servicio;

import com.sistema.regisstro.Sistemademo.AccesoDatos.DatosEcommerce.WebUser;
import com.sistema.regisstro.Sistemademo.Entidades.Roles;
import com.sistema.regisstro.Sistemademo.Entidades.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ServicioUsuario extends UserDetailsService {
        Usuario encontrarporid(String usuario);
        Usuario guardarUsuario(WebUser nuevousuario);
        List<Usuario> consultausuarios();
        List<Roles> consultarroles();
        void borrarusuario(Usuario usuario);
        Usuario actualizarusuario(Usuario actual, WebUser nuevo);
}
