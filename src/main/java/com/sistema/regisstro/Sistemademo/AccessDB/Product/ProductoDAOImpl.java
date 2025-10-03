package com.sistema.regisstro.Sistemademo.AccessDB.Product;

import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public class ProductoDAOImpl implements ProductoDAO{

    private EntityManager a;

    public ProductoDAOImpl(EntityManager a) {
        this.a = a;
    }

    @Override
    public Productos encontrarProductosActual(String vars) {
        TypedQuery<Productos> theQuery = a.createQuery("from Productos where " +
                "nombre=:prdc", Productos.class);
        theQuery.setParameter("prdc", vars);

        Productos producto = null;

        try {
            producto = theQuery.getSingleResult();
        } catch (Exception e) {
            producto = null;
        }

        return producto;
    }

    @Transactional
    @Override
    public void guardaruser(Productos afg) {
        a.merge(afg);
    }

    @Override
    public List<Productos> encontrarProductoss() {
        TypedQuery<Productos> query = a.createQuery("from Productos u " +
                "where u.enabled = true ", Productos.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void eliminarProductos(Productos u) {
        Productos q=a.find(Productos.class,u.getId());
        a.remove(q);
    }

    @Transactional
    @Override
    public Productos actualizarProductos(Productos act) {
        Productos aea=a.find(Productos.class,act.getId());
        Productos usu=a.merge(aea);
        return usu;
    }

}
