package org.example;

import org.example.beans.SimpleBeanService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo")
public class SimpleServlet extends HttpServlet {

    @Inject
    private SimpleBeanService simpleBeanService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream outputStream = resp.getOutputStream();
        HttpSession session = req.getSession(true);
        if (session.getAttribute("simpleBeanService") == null) {
            session.setAttribute("simpleBeanService", simpleBeanService);
        }
        SimpleBeanService bean = (SimpleBeanService) session.getAttribute("simpleBeanService");
        bean.increment();
        resp.setContentType("text/plain");
        outputStream.println(bean.getNumber());
    }
}
