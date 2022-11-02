package com.brief.livecoding_simplon_clone.controllers;

import com.brief.livecoding_simplon_clone.entities.ApprenantEntity;
import com.brief.livecoding_simplon_clone.entities.FormateurEntity;
import com.brief.livecoding_simplon_clone.entities.PromosEntity;
import com.brief.livecoding_simplon_clone.services.ApprenantService;
import com.brief.livecoding_simplon_clone.services.FormateurServices;
import com.brief.livecoding_simplon_clone.services.PromoServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApprenantService apprenantService = new ApprenantService();
        FormateurServices formateurService = new FormateurServices();
        PromoServices promoServices = new PromoServices();

        List<ApprenantEntity> apprenantList = apprenantService.getAll();
        List<FormateurEntity> formateurList = formateurService.getAll();
        List<PromosEntity> promoList = promoServices.getAll();

        request.setAttribute("apprenantList", apprenantList);
        request.setAttribute("formateurList", formateurList);
        request.setAttribute("promoList", promoList);

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action") != null) {
            switch(request.getParameter("action")) {
                case "addPromo" -> {
                    PromosEntity newPromo = new PromosEntity();
                    newPromo.setName(request.getParameter("name"));
                    if(Integer.parseInt(request.getParameter("formateurId")) != 0) {
                        newPromo.setFormateurId(Integer.parseInt(request.getParameter("formateurId")));
                    }

                    PromoServices promoServices = new PromoServices();
                    promoServices.add(newPromo);
                    response.sendRedirect("AdminServlet");
                }
            }
        }


    }
}
