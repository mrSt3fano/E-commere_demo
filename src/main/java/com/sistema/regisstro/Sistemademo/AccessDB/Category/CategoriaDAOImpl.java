package com.sistema.regisstro.Sistemademo.AccessDB.Category;

import com.sistema.regisstro.Sistemademo.Entity.Categorias;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{

    private EntityManager b;

    public CategoriaDAOImpl(EntityManager a) {
        this.b = a;
    }


    @Override
    public Categorias encontrarCategoriactual(String vars) {

        TypedQuery<Categorias> theQuery = b.createQuery("from Categorias where " +
                "nombre=:uso", Categorias.class);
        theQuery.setParameter("uso", vars);

        Categorias catg = null;

        try {
            catg = theQuery.getSingleResult();
        } catch (Exception e) {
            catg = null;
        }

        return catg;
    }

    @Transactional
    @Override
    public void guardarCategoria(Categorias cat) {
        b.merge(cat);
    }

    @Override
    public List<Categorias> encontrarCategoria() {
        TypedQuery<Categorias> query = b.createQuery("from Categorias u " +
                "where u.enabled = true ", Categorias.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void eliminarCategoria(Categorias cat) {
        Categorias q=b.find(Categorias.class,cat.getId());
        b.remove(q);
    }

    @Transactional
    @Override
    public Categorias actualizarCategoria(Categorias cat) {
        Categorias aea=b.find(Categorias.class,cat.getId());
        Categorias usu=b.merge(aea);
        return usu;
    }
}
