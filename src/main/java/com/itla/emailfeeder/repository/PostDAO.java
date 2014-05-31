package com.itla.emailfeeder.repository;

import com.itla.emailfeeder.domain.Admin;
import com.itla.emailfeeder.domain.Post;

import java.util.List;

/**
 * Created by Pimp on 23/05/2014.
 */
public interface PostDAO extends GenericDAO<Post> {

    public List<Post> findAllByCreator(Admin admin);

}
