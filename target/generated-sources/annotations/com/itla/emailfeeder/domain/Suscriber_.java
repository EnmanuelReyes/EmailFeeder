package com.itla.emailfeeder.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-30T22:53:43")
@StaticMetamodel(Suscriber.class)
public class Suscriber_ { 

    public static volatile SingularAttribute<Suscriber, Integer> id;
    public static volatile SingularAttribute<Suscriber, String> email;
    public static volatile SingularAttribute<Suscriber, String> name;
    public static volatile SingularAttribute<Suscriber, Date> suscribedDate;

}