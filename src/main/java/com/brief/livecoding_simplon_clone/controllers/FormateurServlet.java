package com.brief.livecoding_simplon_clone.controllers;

import com.brief.livecoding_simplon_clone.entities.FormateurEntity;
import com.brief.livecoding_simplon_clone.services.ApprenantService;
import com.brief.livecoding_simplon_clone.services.FormateurServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FormateurServlet", value = "/FormateurServlet")
public class FormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormateurServices formateurServices = new FormateurServices();
        List<FormateurEntity> formateurList = formateurServices.getAll();
        request.setAttribute("formateurList", formateurList);

        request.getRequestDispatcher("adminServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "add" -> {
                    FormateurEntity newFormateur = new FormateurEntity();
                    newFormateur.setFirstname(request.getParameter("firstname"));
                    newFormateur.setLastname(request.getParameter("lastname"));
                    newFormateur.setEmail(request.getParameter("email"));
                    newFormateur.setPassword(request.getParameter("password"));

                    FormateurServices formateurServices = new FormateurServices();
                    formateurServices.add(newFormateur);

                }
                case "delete" -> {
                    FormateurServices formateurServices = new FormateurServices();
                    formateurServices.deleteByID(Integer.parseInt(request.getParameter("id")));
                }
            }

            response.sendRedirect("AdminServlet");

        }
    }
}
