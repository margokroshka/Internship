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
<body>
<div class="outer">
    <h2>Dear ${name}, your order:</h2>
    <c:forEach var="goodsL" items="${goodsL}">
        <li>${goodsL.name} ${goodsL.price}$</li>
    </c:forEach>
    <p>Total: $ ${total}</p>

</div>
</body>
</html>
