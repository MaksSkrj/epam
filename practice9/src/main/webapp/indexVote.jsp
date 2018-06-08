<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Voting</title>
</head>
<body>
<form action="/vote" method="get">
    <select name="op">
        <option value="Football">Football</option>
        <option value="Basketball">Basketball</option>
        <option value="Volleyball">Volleyball</option>
    </select>
    <input type="submit" value="submit">
</form>
</body>
</html>

