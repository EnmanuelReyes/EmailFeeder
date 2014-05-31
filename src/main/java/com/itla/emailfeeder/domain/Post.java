package com.itla.emailfeeder.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pimp on 23/05/2014.
 */
@Entity
public class Post {
    @Id @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String text;
    @ManyToOne
    private Admin creator;
    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private Date creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Admin getCreator() {
        return creator;
    }

    public void setCreator(Admin creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
