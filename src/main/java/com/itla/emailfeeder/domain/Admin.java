package com.itla.emailfeeder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Pimp on 24/05/2014.
 */

@Entity
public class Admin implements Serializable{

    @Id @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String user;
    @Column(nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if(this.id != other.id) {
            return false;
        }
        return true;
    }
}
