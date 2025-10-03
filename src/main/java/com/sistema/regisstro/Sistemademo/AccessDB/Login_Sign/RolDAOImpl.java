package com.sistema.regisstro.Sistemademo.AccessDB.Login_Sign;

import com.sistema.regisstro.Sistemademo.Entity.Roles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolDAOImpl implements RolDAO {

    private EntityManager a;

    public RolDAOImpl(EntityManager a) {
        this.a = a;
    }

    @Override
    public Roles encontrarporid(String vars) {

        TypedQuery<Roles> theQuery = a.createQuery("from Roles where " +
                "nombre=:roleName", Roles.class);
        theQuery.setParameter("roleName", vars);

        Roles theRole = null;

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }

        return theRole;
    }

    @Override
    public List<Roles> encontrarroles() {
        TypedQuery<Roles> query = a.createQuery("from Roles", Roles.class);
        return query.getResultList();
    }
}
