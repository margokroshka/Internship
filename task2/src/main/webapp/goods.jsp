<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="org.baranovskaya.config.Config" %>
<%@ page import="org.baranovskaya.dao.Dao" %>
<%@ page import="org.baranovskaya.impl.Goods" %>
<%@ page import="org.baranovskaya.dao.GoodsDao" %>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Order</title>
</head>
<body>
<style>
    .outer {
        text-align: center;
    }
</style>
<div class="outer">
<h2>Hello <%= request.getParameter("name")%>!</h2>
    <%
        session.setAttribute("name", request.getParameter("name"));

        if (session.getAttribute("context") == null) {
            session.setAttribute("context", new AnnotationConfigApplicationContext(Config.class));
        }

        ApplicationContext context = (ApplicationContext) session.getAttribute("context");
        Dao<Goods> dao = (GoodsDao) context.getBean("goodsDao");
        request.setAttribute("goods", dao.getAll());
    %>

    <p>Make your order</p>
    <form id="GoodsForm" action="basket.jsp" method="post">
        <select name="selectedProducts"  multiple>
        <c:forEach items="${goods}" var="goods">
                <option value="${goods.id}" id="product_${goods.id}">
                    <label for="product_${goods.id}" id="quantity_${goods.id}">${goods.name}, ${goods.price}$</label>
        </c:forEach>
        </select>
        <br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>