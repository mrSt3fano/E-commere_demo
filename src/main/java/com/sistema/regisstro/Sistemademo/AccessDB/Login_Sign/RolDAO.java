package com.sistema.regisstro.Sistemademo.AccessDB.Login_Sign;

import com.sistema.regisstro.Sistemademo.Entity.Roles;

import java.util.List;

public interface RolDAO {
    Roles encontrarporid(String a);
    List<Roles> encontrarroles();
}
