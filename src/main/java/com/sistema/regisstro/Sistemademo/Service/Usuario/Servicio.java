package com.sistema.regisstro.Sistemademo.Service.Usuario;

import com.sistema.regisstro.Sistemademo.DTO.WebUser;
import com.sistema.regisstro.Sistemademo.Entity.Roles;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface Servicio extends UserDetailsService {
        Usuario encontrarUsuarioAhora(String usuario);
        Usuario guardarUsuario(WebUser nuevousuario);
        List<Usuario> consultausuarios();
        List<Roles> consultarroles();
        void borrarusuario(Usuario usuario);
        Usuario actualizarusuario(Usuario actual, WebUser nuevo);
}
