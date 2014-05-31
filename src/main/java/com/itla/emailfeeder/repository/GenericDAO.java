package com.itla.emailfeeder.repository;

import com.itla.emailfeeder.service.ConnManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Pimp on 23/05/2014.
 */
public interface GenericDAO<E> {

    EntityManager entityManager = ConnManager.getInstance().createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    Connection connection = ConnManager.getConnection();

    public void add(E e);
    public void delete(E e);
    public List<E> findAll();
    public E findOne(int id);

}
