package com.itla.emailfeeder.repository;

import com.itla.emailfeeder.domain.Suscriber;

import java.util.List;

/**
 * Created by Pimp on 26/05/2014.
 */
public class JPASuscriberDAO implements SuscriberDAO {

    @Override
    public void add(Suscriber suscriber) {
        entityTransaction.begin();
        entityManager.remove(suscriber);
        entityTransaction.commit();
    }

    @Override
    public void delete(Suscriber suscriber) {
        entityTransaction.begin();
        entityManager.remove(suscriber);
        entityTransaction.commit();
    }

    @Override
    public List<Suscriber> findAll() {
        return (List<Suscriber>) entityManager.createQuery("select s from Suscriber s order by s.id").getResultList();
    }

    @Override
    public Suscriber findOne(int id) {
        Suscriber suscriber = entityManager.find(Suscriber.class, id);
        return suscriber;
    }
}
