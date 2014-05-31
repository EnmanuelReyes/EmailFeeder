package com.itla.emailfeeder.service;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import java.util.List;

/**
 * Created by Pimp on 17/05/2014.
 */
public interface Suscriber {

    public void addSuscriber(com.itla.emailfeeder.domain.Suscriber suscriber);
    public List<com.itla.emailfeeder.domain.Suscriber> getAllSuscriber();

}
