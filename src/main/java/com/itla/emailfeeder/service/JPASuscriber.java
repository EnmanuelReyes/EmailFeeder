package com.itla.emailfeeder.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Pimp on 26/05/2014.
 */
public class JPASuscriber implements Suscriber {

    EntityManager entityManager = ConnManager.getInstance().createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    @Override
    public void addSuscriber(com.itla.emailfeeder.domain.Suscriber suscriber) {
        entityTransaction.begin();
        entityManager.persist(suscriber);
        entityTransaction.commit();
    }

    @Override
    public List<com.itla.emailfeeder.domain.Suscriber> getAllSuscriber() {
        return (List<com.itla.emailfeeder.domain.Suscriber>) entityManager.createQuery("select s from Suscriber s order by s.id").getResultList();
    }
}
