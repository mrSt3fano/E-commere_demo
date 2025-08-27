package com.sistema.regisstro.Sistemademo.AccesoDatos;

import com.sistema.regisstro.Sistemademo.Entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private EntityManager s;

    public UsuarioDAOImpl(EntityManager s) {
        this.s = s;
    }

    @Override
    public Usuario encontrarporid(String a) {

        TypedQuery<Usuario> query = s.createQuery("from Usuario where nombre=:uName" +
                " and enabled=true ", Usuario.class);
        query.setParameter("uName", a);

        Usuario theUser = null;
        try {
            theUser = query.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public List<Usuario> encontrarUsuarios() {

        TypedQuery<Usuario> query = s.createQuery("from Usuario u " +
                "where u.enabled = true ", Usuario.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void eliminarUsuario(Usuario u) {
        Usuario q=s.find(Usuario.class,u.getId());
        s.remove(q);
    }

    @Override
    @Transactional
    public Usuario actualizarusuario(Usuario act) {
        Usuario aea=s.find(Usuario.class,act.getId());
        Usuario usu=s.merge(aea);
        return usu;
    }

    @Override
    @Transactional
    public void guardaruser(Usuario afg) {
        s.merge(afg);
    }



}
