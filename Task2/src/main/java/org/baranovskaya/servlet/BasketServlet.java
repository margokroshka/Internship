package org.baranovskaya.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.baranovskaya.dao.GoodsDao;
import org.baranovskaya.impl.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/basket")
public class BasketServlet extends HttpServlet {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedProducts = request.getParameterValues("selectedProducts");
        List<Integer> ids = Arrays.stream(selectedProducts)
                .map(Integer::parseInt)
                .toList();
        List<Goods> goods = goodsDao.getAll().stream()
                .filter(goods1 -> ids.contains(goods1.getId()))
                .toList();
        int sum = (int) goods.stream().mapToDouble(Goods::getPrice).sum();
        request.setAttribute("goodsL", goods);
        request.setAttribute("total", sum);

        request.getRequestDispatcher("basket.jsp").forward(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
    }
}
