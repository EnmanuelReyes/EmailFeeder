package com.itla.emailfeeder.web;

import com.itla.emailfeeder.repository.JPASuscriberDAO;
import com.itla.emailfeeder.repository.SuscriberDAO;
import com.itla.emailfeeder.service.EmailManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Pimp on 17/05/2014.
 */

@Controller
public class SuscriberController {

    SuscriberDAO suscriber = new JPASuscriberDAO();

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="/suscriber.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Se accedio a la pagina de suscribirse");
        return new ModelAndView("WEB-INF/views/suscriber.jsp");
    }

    @RequestMapping(value="/suscriber.htm", method = RequestMethod.POST)
    public String doSuscribe(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Suscribiendo usuario con email " + request.getParameter("email"));

        com.itla.emailfeeder.domain.Suscriber suscriber1 = new com.itla.emailfeeder.domain.Suscriber();
        suscriber1.setName(request.getParameter("name"));
        suscriber1.setEmail(request.getParameter("email"));
        suscriber1.setSuscribedDate(new Date());
        suscriber.add(suscriber1);

        logger.info("Mandandole email de saludos");
        EmailManager.sendHelloEmail(suscriber1);
        return "redirect:index.htm";
    }

    @RequestMapping(value = "/unsuscribe", method = RequestMethod.GET)
    public String unSuscribe(@RequestParam("id") int id)
            throws ServletException, IOException {
        suscriber.delete(suscriber.findOne(id));
        return "redirect:index.htm";
    }
}
