package org.baranovskaya.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.baranovskaya.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

@WebServlet(urlPatterns = "/goods")
public class GoodsServlet extends HttpServlet {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        session.setAttribute("name", req.getParameter("name"));

        req.setAttribute("goods", goodsDao.getAll());
        req.getRequestDispatcher("goods.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
    }
}
