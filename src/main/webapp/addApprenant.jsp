<%--
  Created by IntelliJ IDEA.
  User: DarkFang
  Date: 11/2/2022
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Apprenant</title>
</head>
<body>
<form action="ApprenantServlet" method="post">
  <lable for="firstname">first name
    <input type="text" name="firstname" id="firstname"/>
  </lable>
  <lable for="lastname">last name
    <input type="text" name="lastname" id="lastname"/>
  </lable>
  <lable for="email">email
    <input type="email" name="email" id="email"/>
  </lable>
  <lable for="password">password
    <input type="text" name="password" id="password"/>
  </lable>
  <input type="hidden" name="action" value="add"/>
  <button type="submit">Add</button>
</form>
</body>
</html>
