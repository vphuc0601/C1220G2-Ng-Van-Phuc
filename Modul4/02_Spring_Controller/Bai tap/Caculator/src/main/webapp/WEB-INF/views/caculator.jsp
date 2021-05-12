<%--
  Created by IntelliJ IDEA.
  User: Au
  Date: 3/30/2021
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>CALCULATOR</h1>
<form action="/caculator" method="post">
    <table>
        <tr>
            <td colspan="2"><input type="number" name="number1"></td>
            <td colspan="2"><input type="number" name="number2"></td>
        </tr>
        <tr>
            <td><button type="submit" name="caculator" value="Addition(+)">Addition(+)</button></td>
            <td><button type="submit" name="caculator" value="Subtraction(-)">Subtraction(-)</button></td>
            <td><button type="submit" name="caculator" value="Multiplication(x)">Multiplication(x)</button></td>
            <td><button type="submit" name="caculator" value="Division(/)">Division(/)</button></td>
        </tr>
    </table>
</form>
<h3>Result: ${result}</h3>
</body>
</html>