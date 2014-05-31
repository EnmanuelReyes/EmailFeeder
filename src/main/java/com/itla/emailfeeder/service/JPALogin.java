package com.itla.emailfeeder.service;

import com.itla.emailfeeder.domain.Admin;
import com.itla.emailfeeder.repository.JPAAdminDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Pimp on 24/05/2014.
 */
public class JPALogin implements Login {

    JPAAdminDAO jpaAdminDAO = new JPAAdminDAO();

    @Override
    public boolean authentificator(String user, String password) {
        for(Admin admin : jpaAdminDAO.findAll()) {
            if (admin.getUser().equalsIgnoreCase(user) && admin.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }
}
