package com.itla.emailfeeder.repository;

import com.itla.emailfeeder.domain.Admin;


/**
 * Created by Pimp on 26/05/2014.
 */
public interface AdminDAO extends GenericDAO<Admin> {

    public Admin findOne(String name);

}
