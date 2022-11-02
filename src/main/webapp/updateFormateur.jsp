<%@ page import="com.brief.livecoding_simplon_clone.entities.PromosEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.brief.livecoding_simplon_clone.entities.FormateurEntity" %><%--
  Created by IntelliJ IDEA.
  User: DarkFang
  Date: 11/2/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Formateur</title>
</head>
<body>
<%
    List<PromosEntity> nullPromos =(List<PromosEntity>) request.getAttribute("nullPromos");
    FormateurEntity selectedFormateur = (FormateurEntity) request.getAttribute("selectedFormateur");
%>
<form action="FormateurServlet" method="post">
    <lable for="firstname">first name
        <input type="text" name="firstname" id="firstname" value="<%=selectedFormateur.getFirstname()%>"/>
    </lable>
    <lable for="lastname">last name
        <input type="text" name="lastname" id="lastname" value="<%=selectedFormateur.getLastname()%>"/>
    </lable>
    <lable for="email">email
        <input type="email" name="email" id="email" value="<%=selectedFormateur.getEmail()%>"/>
    </lable>
    <lable for="password">password
        <input type="text" name="password" id="password" value="<%=selectedFormateur.getPassword()%>"/>
    </lable>
    <label>AssignTo</label>
    <select name="promoId">
        <option selected value="null"></option>
       <%
       for (PromosEntity promosEntity: nullPromos){
       %>
        <option value="<%=promosEntity.getId() %>"><%=promosEntity.getName() %> </option>
        <%}%>
    </select>
    <input type="hidden" name="id" value="<%=selectedFormateur.getId()%>"/>
    <input type="hidden" name="action" value="update"/>
    <button type="submit">update</button>
</form>
</body>
</html>
