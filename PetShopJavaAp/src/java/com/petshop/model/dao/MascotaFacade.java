/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.model.dao;

import com.petshop.model.entity.Mascota;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Giancarlo
 */
@Stateless
public class MascotaFacade extends AbstractFacade<Mascota> {

    @PersistenceContext(unitName = "VentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MascotaFacade() {
        super(Mascota.class);
    }
    
}