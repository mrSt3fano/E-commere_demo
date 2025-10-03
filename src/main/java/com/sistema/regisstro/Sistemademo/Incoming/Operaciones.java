package com.sistema.regisstro.Sistemademo.Incoming;

import com.sistema.regisstro.Sistemademo.Entity.Usuario;

public interface Operaciones {


    void guardarUsuario(Usuario usuarionuevo);

    Usuario encontrarUsuarioporid(int theId);

    void borrarUsuarioporid(int theId);

}
