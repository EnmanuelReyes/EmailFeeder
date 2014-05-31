package com.itla.emailfeeder.domain;

import com.itla.emailfeeder.domain.Admin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-30T22:53:43")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, Date> creationDate;
    public static volatile SingularAttribute<Post, String> text;
    public static volatile SingularAttribute<Post, String> subject;
    public static volatile SingularAttribute<Post, Admin> creator;

}