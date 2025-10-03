package com.sistema.regisstro.Sistemademo.AccessDB.Login_Sign;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;

import java.util.List;

public interface UsuarioDAO {
    Usuario encontrarUsuarioActual(String a);
    void guardaruser(Usuario afg);
    List<Usuario> encontrarUsuarios();
    void eliminarUsuario(Usuario u);
    Usuario actualizarusuario(Usuario act);

}
