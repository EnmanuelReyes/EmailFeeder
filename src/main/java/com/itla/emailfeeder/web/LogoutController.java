package com.itla.emailfeeder.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Pimp on 24/05/2014.
 */
@Controller
public class LogoutController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String doLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

        if (!(StringUtils.isEmpty(session.getAttribute("user")))) {
            session.invalidate();
        }
        return "redirect:index.htm";
    }
}
