package com.itla.emailfeeder.web;

import com.itla.emailfeeder.domain.Admin;
import com.itla.emailfeeder.domain.Post;
import com.itla.emailfeeder.repository.JPAAdminDAO;
import com.itla.emailfeeder.repository.JPAPostDAO;
import com.itla.emailfeeder.repository.PostDAO;
import com.itla.emailfeeder.service.EmailManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Pimp on 23/05/2014.
 */
@Controller
public class PosterController {

    protected final Log logger = LogFactory.getLog(getClass());

    PostDAO postDAO = new JPAPostDAO();
    JPAAdminDAO jpaAdminDAO = new JPAAdminDAO();

    EmailManager emailManager = new EmailManager();

    @RequestMapping(value = "/postear.htm", method = RequestMethod.POST)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

        Post post = new Post();

        post.setSubject(request.getParameter("subject"));
        post.setText(request.getParameter("text"));
        post.setCreationDate(new Date());
        post.setCreator(((Admin) session.getAttribute("user")));

        postDAO.add(post);

        logger.info("Posteando nuevo contenido.");

        emailManager.sendEmails(post);

        logger.info("Mandando correos a los suscriptores");

        return "redirect:/index.htm";
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView returnPost(@RequestParam("id") int id) throws ServletException, IOException {

        logger.info("Accediendo a determinado post");
        return new ModelAndView("WEB-INF/views/post.jsp", "post", postDAO.findOne(id));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView returnPostsByUser(@RequestParam("id") int id, HttpSession session)
            throws ServletException, IOException {

        logger.info("Accediendo a determinados posts de un usuario");
        PagedListHolder postList = new PagedListHolder<Post>(this.postDAO.findAllByCreator(jpaAdminDAO.findOne(id)));
        postList.setPageSize(3);
        postList.setSort(new MutableSortDefinition("creationDate", true, true));

        session.setAttribute("page", postList);
        return new ModelAndView("WEB-INF/views/home.jsp", "posts", postList);
    }
}
