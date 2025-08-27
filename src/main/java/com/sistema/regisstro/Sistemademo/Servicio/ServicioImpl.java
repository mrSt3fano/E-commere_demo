package com.sistema.regisstro.Sistemademo.Servicio;

import com.sistema.regisstro.Sistemademo.AccesoDatos.DatosEcommerce.WebUser;
import com.sistema.regisstro.Sistemademo.AccesoDatos.RolDAO;
import com.sistema.regisstro.Sistemademo.AccesoDatos.UsuarioDAO;
import com.sistema.regisstro.Sistemademo.Entidades.Roles;
import com.sistema.regisstro.Sistemademo.Entidades.Usuario;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ServicioImpl implements ServicioUsuario{

    private UsuarioDAO u;
    private RolDAO r;
    private BCryptPasswordEncoder bc;

    @Autowired
    public ServicioImpl(UsuarioDAO u, RolDAO r, BCryptPasswordEncoder b) {
        this.u = u;
        this.r = r;
        bc=b;
    }


    @Override
    public Usuario encontrarporid(String usuario) {
        return u.encontrarporid(usuario);
    }

    @Override
    public Usuario guardarUsuario(WebUser nuevousuario) {

            Usuario vars = new Usuario();

            // assign user details to the user object
            vars.setNombre(nuevousuario.getNombre());
            vars.setPassword(bc.encode(nuevousuario.getPassword()));

            try {
                if (nuevousuario.getImagene() != null && !nuevousuario.getImagene().isEmpty()) {
                    vars.setImagen(nuevousuario.getImagene().getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            vars.setEnabled(true);

            // give user default role of "employee"
            vars.setRoles(Arrays.asList(r.encontrarporid("ROLE_CLIENTE")));

            // save user in the database
            u.guardaruser(vars);

            return vars;
    }

    @Override
    public List<Usuario> consultausuarios() {
        List<Usuario> user=u.encontrarUsuarios();
        return user;
    }

    @Override
    public List<Roles> consultarroles() {
        List<Roles> rol=r.encontrarroles();
        return rol;
    }

    @Override
    @Transactional
    public void borrarusuario(Usuario usuario) {
        u.eliminarUsuario(usuario);
    }

    @Override
    public Usuario actualizarusuario(Usuario actual, WebUser nuevo) {

        // assign user details to the user object
        actual.setNombre(nuevo.getNombre());
        actual.setPassword(bc.encode(nuevo.getPassword()));

        try {
            if (nuevo.getImagene() != null && !nuevo.getImagene().isEmpty()) {
                actual.setImagen(nuevo.getImagene().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // save user in the database
        u.guardaruser(actual);

        return actual;
    }


    @Override
    public UserDetails loadUserByUsername(String sss) throws UsernameNotFoundException {
        Usuario user = u.encontrarporid(sss);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getNombre(), user.getPassword(),
                authorities);
    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Roles> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Roles tempRole : roles) {
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getNombre());
            authorities.add(tempAuthority);
        }

        return authorities;
    }


    }

