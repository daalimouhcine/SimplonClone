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
    <link rel="stylesheet" href="apprenant.css">
    <link rel="stylesheet" href="https://unpkg.com/primitive-ui/dist/css/main.css" />
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

<br>
<br>
<br>

<h2>Formateurs</h2>
<h2>
    <a href="addFormateur.jsp">Add Formateur</a>
</h2>
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
        for(FormateurEntity formateur : formateurList) {
    %>
    <tr>
        <td><%=formateur.getFirstname()%></td>
        <td><%=formateur.getLastname()%></td>
        <td><%=formateur.getEmail()%></td>
        <td><%=formateur.getPassword()%></td>
        <td class="action">
            <form action="FormateurServlet" method="post">
                <input type="hidden" name="id" value="<%=formateur.getId()%>"/>
                <input type="hidden" name="action" value="delete"/>
                <button type="submit">DELETE</button>
            </form>
            <form action="FormateurServlet" method="post">
                <input type="hidden" name="id" value="<%=formateur.getId()%>"/>
                <input type="hidden" name="action" value="edit"/>
                <button type="submit">EDIT</button>
            </form>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>

<br>
<br>
<br>

<h2>Apprenants</h2>
<h2>
    <a href="addApprenant.jsp">Add Apprenant</a>
</h2>
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
        for(ApprenantEntity apprenant : apprenantList) {
    %>
    <tr>
        <td><%=apprenant.getFirstname()%></td>
        <td><%=apprenant.getLastname()%></td>
        <td><%=apprenant.getEmail()%></td>
        <td><%=apprenant.getPassword()%></td>
        <td class="action">
            <form action="ApprenantServlet" method="post">
                <input type="hidden" name="id" value="<%=apprenant.getId()%>"/>
                <input type="hidden" name="action" value="delete"/>
                <button type="submit">DELETE</button>
            </form>
            <form action="ApprenantServlet" method="post">
                <input type="hidden" name="id" value="<%=apprenant.getId()%>"/>
                <input type="hidden" name="action" value="edit"/>
                <button type="submit">EDIT</button>
            </form>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
