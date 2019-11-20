package com.petshop.model.dao;

import com.petshop.model.entity.Dueno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DuenoFacade extends AbstractFacade<Dueno> {

    @PersistenceContext(unitName = "VentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DuenoFacade() {
        super(Dueno.class);
    }
    
    public List<Dueno> buscarActivos(){
        List<Dueno> lista = null;
        String jpql = "select d from Dueno d";
        Query q = em.createQuery(jpql);
        q.setHint("javax.persistence.cache.storeMode", "REFRESH");
        lista = q.getResultList();
        return lista;
    }
}
