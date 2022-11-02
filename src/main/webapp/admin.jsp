<%@ page import="java.util.List" %>
<%@ page import="com.brief.livecoding_simplon_clone.entities.PromosEntity" %>
<%@ page import="com.brief.livecoding_simplon_clone.entities.FormateurEntity" %>
<%@ page import="com.brief.livecoding_simplon_clone.entities.ApprenantEntity" %><%--
  Created by IntelliJ IDEA.
  User: DarkFang
  Date: 11/2/2022
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<%
    List<PromosEntity> promoList =(List<PromosEntity>) request.getAttribute("promoList");
    List<FormateurEntity> formateurList =(List<FormateurEntity>) request.getAttribute("formateurList");
    List<ApprenantEntity> apprenantList =(List<ApprenantEntity>) request.getAttribute("apprenantList");
%>

<h2>Promos</h2>
<h2>
    <a href="addPromo.jsp">Add Promo</a>
</h2>
<table>
    <thead>
        <td>Name</td>
        <td>Formateur ID</td>
    </thead>
    <tbody>
        <%
            for(PromosEntity promo : promoList) {
        %>
            <tr>
            <td><%=promo.getName()%></td>
            <td><%=promo.getFormateurId()%></td>
            </tr>
        <%}%>
    </tbody>
</table>
</body>
</html>
