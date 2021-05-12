<%--
  Created by IntelliJ IDEA.
  User: Au
  Date: 3/29/2021
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/convert">
    <div>
        <p>Number:</p>
        <input name="number" type="number">
        <select name="unit">
            <option>VND</option>
            <option>USD</option>
        </select>
    </div>
    <input type="submit" value="CONVERT">
</form>
</body>
</html>
