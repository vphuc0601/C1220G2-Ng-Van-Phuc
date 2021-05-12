<%--
  Created by IntelliJ IDEA.
  User: Au
  Date: 3/30/2021
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="webapp/bootstrap413/css/bootstrap.min.css">
<link rel="stylesheet" href="webapp/datatables/css/dataTables.bootstrap4.min.css">
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form action="save" class="form-check form-check-inline" method="post">
    <input type="checkbox" id="lettuce" name="spices" value="lettuce">
    <label for="lettuce"> Lettuce</label><br>
    <input type="checkbox" id="tomato" name="spices" value="tomato">
    <label for="tomato"> Tomato</label><br>
    <input type="checkbox" id="mustard" name="spices" value="mustard">
    <label for="mustard"> Mustard</label><br>
    <input type="checkbox" id="sprouts" name="spices" value="sprouts">
    <label for="sprouts"> Sprouts</label><br>
    <input type="submit" value="Save">
</form>
<h1>You have chosen the Sandwich section served with:${spice}</h1>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
