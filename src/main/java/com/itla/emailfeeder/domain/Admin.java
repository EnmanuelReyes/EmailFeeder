package com.itla.emailfeeder.domain;

import javax.persistence.*;
import java.io.Serializable;

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
    //private boolean isActive;
    private String lolazo;

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

    public String getLolazo() {
        return lolazo;
    }

    public void setLolazo(String lolazo) {
        this.lolazo = lolazo;
    }

    /*
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }*/

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
