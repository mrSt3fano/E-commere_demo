package com.sistema.regisstro.Sistemademo.AccesoDatos;

import com.sistema.regisstro.Sistemademo.Entidades.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UsuarioDAO {
    Usuario encontrarporid(String a);
    void guardaruser(Usuario afg);
    List<Usuario> encontrarUsuarios();
    void eliminarUsuario(Usuario u);
    Usuario actualizarusuario(Usuario act);

}
