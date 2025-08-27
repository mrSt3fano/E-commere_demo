package com.sistema.regisstro.Sistemademo.AccesoDatos.DatosEcommerce;

import com.sistema.regisstro.Sistemademo.Entidades.Usuario;

public interface Operaciones {


    void guardarUsuario(Usuario usuarionuevo);

    Usuario encontrarUsuarioporid(int theId);

    void borrarUsuarioporid(int theId);

}
