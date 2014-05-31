package com.itla.emailfeeder.web;

import com.itla.emailfeeder.domain.Admin;
import com.itla.emailfeeder.repository.JPAAdminDAO;
import com.itla.emailfeeder.service.JPALogin;
import com.itla.emailfeeder.service.JdbcLogin;
import com.itla.emailfeeder.service.Login;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Pimp on 23/05/2014.
 */
@Controller
public class LoginController {

    protected final Log logger = LogFactory.getLog(getClass());

    private Login login = new JPALogin();
    private JPAAdminDAO jpaAdminDAO = new JPAAdminDAO();

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView returnLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {


        Admin admin = new Admin();
        admin.setUser("enmanuel");
        admin.setPassword("password");

        logger.info("Accedio a el panel de administracion");

        if (session.getAttribute("user") == null) {

            jpaAdminDAO.add(admin);
            return new ModelAndView("WEB-INF/views/login.jsp");
        }

        return new ModelAndView("WEB-INF/views/admin.jsp", "user", session.getAttribute("user"));
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

        logger.info("Intento de Login");

        if (login.authentificator(request.getParameter("name"), request.getParameter("password"))) {
            logger.info("USER LOGUEADO!: " + request.getParameter("name"));

            session.setAttribute("user", jpaAdminDAO.findOne(request.getParameter("name")));
            return new ModelAndView("WEB-INF/views/admin.jsp", "user", session.getAttribute("user"));
        }
        return new ModelAndView("WEB-INF/views/login.jsp");
    }

}
