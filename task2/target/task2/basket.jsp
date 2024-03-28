<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="org.baranovskaya.impl.Goods" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.baranovskaya.dao.GoodsDao" %>
<%@ page import="org.baranovskaya.dao.Dao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Check</title>
</head>
<style>
    .outer {
        text-align: center;
    }
</style>
<div class="outer">
    <body>
    <h2>Dear <%= session.getAttribute("name")%>, your order:</h2>
    <%
        String[] selectedProducts = request.getParameterValues("selectedProducts");
        List<Integer> ids = Arrays.stream(selectedProducts)
                .map(Integer::parseInt)
                .toList();
        ApplicationContext context = (ApplicationContext) session.getAttribute("context");
        Dao<Goods> dao = (GoodsDao) context.getBean("goodsDao");
        List<Goods> goods = dao.getAll().stream()
                .filter(goods1 -> ids.contains(goods1.getId()))
                .toList();
        int sum = (int) goods.stream().mapToDouble(Goods::getPrice).sum();
        request.setAttribute("goodsL", goods);
        request.setAttribute("total", sum);
    %>
    <c:forEach var="goodsL" items="${goodsL}">
    <li>${goodsL.name} ${goodsL.price}$</li>
    </c:forEach>
    <p>Total: $ ${total}</p>

</div>
</body>
</html>
