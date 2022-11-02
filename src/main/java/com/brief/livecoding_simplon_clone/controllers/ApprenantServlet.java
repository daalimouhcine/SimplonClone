package com.brief.livecoding_simplon_clone.controllers;

import com.brief.livecoding_simplon_clone.entities.ApprenantEntity;
import com.brief.livecoding_simplon_clone.services.ApprenantService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApprenantServlet", value = "/ApprenantServlet")
public class ApprenantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApprenantService apprenantService = new ApprenantService();
        List<ApprenantEntity> apprenantList = apprenantService.getAll();

        request.setAttribute("apprenantList", apprenantList);
        request.getRequestDispatcher("apprenant.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "add"  -> {
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");

                    ApprenantEntity newApprenant = new ApprenantEntity();
                    newApprenant.setFirstname(firstname);
                    newApprenant.setLastname(lastname);
                    newApprenant.setEmail(email);
                    newApprenant.setPassword(password);

                    ApprenantService apprenantService = new ApprenantService();
                    apprenantService.add(newApprenant);
                }
                case "delete" -> {
                    ApprenantService apprenantService = new ApprenantService();
                    apprenantService.deleteById(Integer.parseInt(request.getParameter("id")));
                }


            }

        }
//        doGet(request,response);
        response.sendRedirect("AdminServlet");

    }
}
