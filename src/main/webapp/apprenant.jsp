<%@ page import="java.util.List" %>
<%@ page import="com.brief.livecoding_simplon_clone.entities.ApprenantEntity" %><%--
  Created by IntelliJ IDEA.
  User: DarkFang
  Date: 11/2/2022
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>apprenant</title>
    <link rel="stylesheet" href="apprenant.css">
</head>
<body>
<table>
    <thead>
    <td>first name</td>
    <td>last name</td>
    <td>email</td>
    <td>password</td>
    <td>ACTION</td>
    </thead>
    <tbody>
        <%
            List<ApprenantEntity> apprenantList = (List<ApprenantEntity>) request.getAttribute("apprenantList");
            for(ApprenantEntity apprenant : apprenantList) {
        %>
            <tr>
                <td><%=apprenant.getFirstname()%></td>
                <td><%=apprenant.getLastname()%></td>
                <td><%=apprenant.getEmail()%></td>
                <td><%=apprenant.getPassword()%></td>
                <td>
                    <form action="ApprenantServlet" method="post">
                        <input type="hidden" name="id" value="<%=apprenant.getId()%>"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">DELETE</button>
                    </form>
                </td>
            </tr>
        <%}%>
    </tbody>
</table>

<br>

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
