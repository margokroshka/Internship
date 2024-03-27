<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<style>
    .outer {
        text-align: center;
    }
</style>
<div class="outer">
    <h2>Welcome to Online shop!</h2>
    <form action="goods.jsp" method="get">
        <input type="text" name="name" placeholder="Enter your name" required>
        <br><br>
        <input type="submit" value="Enter">
    </form>
</div>
</body>
</html>
