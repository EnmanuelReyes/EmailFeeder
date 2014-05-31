package com.itla.emailfeeder.repository;

import com.itla.emailfeeder.domain.Admin;
import java.util.List;

/**
 * Created by Pimp on 24/05/2014.
 */
public class JPAAdminDAO implements AdminDAO {

    @Override
    public void add(Admin admin) {
        entityTransaction.begin();
        entityManager.persist(admin);
        entityTransaction.commit();
    }

    @Override
    public void delete(Admin admin) {
        entityTransaction.commit();
        entityManager.remove(admin);
        entityTransaction.commit();
    }

    @Override
    public Admin findOne(String name) {
        for(Admin admin : findAll()) {
            if (admin.getUser().equals(name)) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin findOne(int id) {
        Admin admin = entityManager.find(Admin.class, id);
        return admin;

    }

    @Override
    public List<Admin> findAll() {
        return (List<Admin>) entityManager.createQuery("select a from Admin a order by a.id").getResultList();
    }

}
