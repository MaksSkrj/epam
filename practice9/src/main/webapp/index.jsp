<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calc" method="get">
    First operand:<br>
    <input type="text" name="x"><br>
    Second operand:<br>
    <input type="text" name="y"><br><br>
    <select name="op">
        <option value="plus">+</option>
        <option value="minus">-</option>
    </select><br><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
