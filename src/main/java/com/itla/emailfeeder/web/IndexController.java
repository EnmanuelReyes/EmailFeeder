package com.itla.emailfeeder.web;

import com.itla.emailfeeder.domain.Post;
import com.itla.emailfeeder.repository.JPAPostDAO;
import com.itla.emailfeeder.repository.PostDAO;
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

/**
 * Created by Pimp on 23/05/2014.
 */
@Controller
public class IndexController {

    protected final Log logger = LogFactory.getLog(getClass());

    PostDAO postDAO = new JPAPostDAO();


    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

        logger.info("Se accedio a la Homepage");

        PagedListHolder postList = new PagedListHolder<Post>(this.postDAO.findAll());
        postList.setPageSize(3);
        postList.setSort(new MutableSortDefinition("creationDate", true, true));

        session.setAttribute("page", postList);
        return new ModelAndView("WEB-INF/views/home.jsp", "posts", postList);
    }
    @RequestMapping(value = "page")
    public ModelAndView doPagination(HttpServletRequest request, HttpSession session)
            throws ServletException, IOException {

        String page = request.getParameter("page");

        PagedListHolder<Post> postList = (PagedListHolder<Post>) session.getAttribute("page");

        if (postList == null) {
            logger.info("No se encontro la pagina solicitada");
        }
        logger.info("testing");
        if ("siguiente".equalsIgnoreCase(page)) {
            postList.nextPage();
        } else if ("anterior".equalsIgnoreCase(page)) {
            postList.previousPage();
        }

        return new ModelAndView("WEB-INF/views/home.jsp", "posts", postList);

    }

}
