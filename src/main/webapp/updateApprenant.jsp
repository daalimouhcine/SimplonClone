<%@ page import="com.brief.livecoding_simplon_clone.entities.ApprenantEntity" %>
<%@ page import="com.brief.livecoding_simplon_clone.entities.PromostoapprenantEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.brief.livecoding_simplon_clone.entities.PromosEntity" %><%--
  Created by IntelliJ IDEA.
  User: DarkFang
  Date: 11/2/2022
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Apprenant</title>
    <link rel="stylesheet" href="https://unpkg.com/primitive-ui/dist/css/main.css" />
</head>
<body>
    <%
        ApprenantEntity selectedApprenant = (ApprenantEntity) request.getAttribute("selectedApprenant");
        PromostoapprenantEntity promoToApprenant = null;
        if(request.getAttribute("promoToApprenant") != null) {
            promoToApprenant = (PromostoapprenantEntity) request.getAttribute("promoToApprenant");
        }
        List<PromosEntity> promosList = (List<PromosEntity>) request.getAttribute("promosList");
    %>
    <form action="ApprenantServlet" method="post">
        <lable for="firstname">first name
            <input type="text" name="firstname" id="firstname" value="<%=selectedApprenant.getFirstname()%>"/>
        </lable>
        <lable for="lastname">last name
            <input type="text" name="lastname" id="lastname" value="<%=selectedApprenant.getLastname()%>"/>
        </lable>
        <lable for="email">email
            <input type="email" name="email" id="email" value="<%=selectedApprenant.getEmail()%>"/>
        </lable>
        <lable for="password">password
            <input type="text" name="password" id="password" value="<%=selectedApprenant.getPassword()%>"/>
        </lable>
        <lable for="promo">promo
            <select name="promo" id="promo">
                <%
                    if (promoToApprenant == null) {
                %>
                    <option selected value="">no promo</option>
                <%}%>
                <%
                    for (PromosEntity promo : promosList) {
                        if (promoToApprenant != null) {
                            if (promo.getId() == promoToApprenant.getPromoId()) {
                %>
                                <option value="<%=promo.getId()%>" selected><%=promo.getName()%></option>
                <%
                            } else {
                %>
                                <option value="<%=promo.getId()%>"><%=promo.getName()%></option>
                <%
                            }
                        } else {
                %>
                            <option value="<%=promo.getId()%>"><%=promo.getName()%></option>
                <%
                        }
                    }
                %>
            </select>
        </lable>
        <input type="hidden" name="id" value="<%=selectedApprenant.getId()%>" />
        <input type="hidden" name="action" value="update"/>
        <button type="submit">Update</button>
    </form>
</body>
</html>
