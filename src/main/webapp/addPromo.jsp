<%--
  Created by IntelliJ IDEA.
  User: DarkFang
  Date: 11/2/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Promo</title>
</head>
<body>
    <form action="AdminServlet" method="post">
        <label for="name">
            <input type="text" name="name" id="name" required/>
        </label>
        <label for="FormateurId">
            <input type="text" name="formateurId" id="formateurId" value="0"/>
        </label>
        <input type="hidden" name="action" value="addPromo"/>
        <button type="submit">Add Promo</button>
    </form>
</body>
</html>