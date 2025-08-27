package com.sistema.regisstro.Sistemademo.AccesoDatos;

import com.sistema.regisstro.Sistemademo.Entidades.Roles;
import com.sistema.regisstro.Sistemademo.Entidades.Usuario;

import java.util.List;

public interface RolDAO {
    Roles encontrarporid(String a);
    List<Roles> encontrarroles();
}
