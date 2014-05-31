package com.itla.emailfeeder.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pimp on 25/05/2014.
 */
@Entity
public class Suscriber {

    @Id @GeneratedValue
    private int id;
    private String name;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date suscribedDate;

    public Date getSuscribedDate() {
        return suscribedDate;
    }

    public void setSuscribedDate(Date suscribedDate) {
        this.suscribedDate = suscribedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
