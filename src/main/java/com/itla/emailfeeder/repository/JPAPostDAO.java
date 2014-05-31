package com.itla.emailfeeder.repository;

import com.itla.emailfeeder.domain.Admin;
import com.itla.emailfeeder.domain.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pimp on 23/05/2014.
 */
public class JPAPostDAO implements PostDAO {



    @Override
    public void add(Post post) {
        entityTransaction.begin();
        entityManager.persist(post);
        entityTransaction.commit();
    }

    @Override
    public void delete(Post post) {
        entityTransaction.begin();
        entityManager.remove(post);
        entityTransaction.commit();
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) entityManager.createQuery("select p from Post p order by p.id desc").getResultList();
    }

    @Override
    public Post findOne(int id) {
        Post post = entityManager.find(Post.class, id);
        return post;
    }

    @Override
    public List<Post> findAllByCreator(Admin admin) {
        List<Post> postList = new ArrayList<Post>();
        for(Post post : findAll()) {
            System.out.println("el crador del post" + post.getCreator() + " y el que le pasamos" + admin );
            if(post.getCreator().equals(admin)) {
                System.out.println("se agrego uno");
                postList.add(post);
            }
        }
        System.out.println("devolviendo lista");
        return postList;
    }
}
