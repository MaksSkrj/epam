<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <head>
        <title>Statistics</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
</head>
<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">System</th>
        <th scope="col">Votes</th>
    </tr>
    </thead>

    <tbody>

        <% Map<String, Integer> map = (Map<String, Integer>)(request.getAttribute("votes"));
    for (Map.Entry<String, Integer> entry : map.entrySet()) { %>
    <tr>
        <td><%=entry.getKey()%></td>
        <td><%=entry.getValue()%></td>
    </tr>
        <% } %>
</table>
<a href="indexVote.jsp">Go back to voting</a>
</body>
</html>
