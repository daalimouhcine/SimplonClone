package com.brief.livecoding_simplon_clone.controllers;

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
                    newFormateur.setSpecialiter(request.getParameter("specialiter"));

                    FormateurServices formateurServices = new FormateurServices();
                    formateurServices.add(newFormateur);

                }
                case "delete" -> {
                    FormateurServices formateurServices = new FormateurServices();
                    formateurServices.deleteByID(Integer.parseInt(request.getParameter("id")));
                }
                case "edit" -> {
                    if(request.getParameter("id") != null) {
                        FormateurServices formateurServices = new FormateurServices();
                        PromoServices promoServices = new PromoServices();

                        FormateurEntity selectedFormateur = formateurServices.findbyId(Integer.parseInt(request.getParameter("id")));
                        List<PromosEntity> nullPromos = promoServices.getAllNulls();

                        request.setAttribute("selectedFormateur", selectedFormateur);
                        request.setAttribute("nullPromos", nullPromos);

                        request.getRequestDispatcher("updateFormateur.jsp").forward(request, response);
                    }

                }
                case "update" -> {
                    FormateurEntity updateFormateur = new FormateurEntity();
                    updateFormateur.setFirstname(request.getParameter("firstname"));
                    updateFormateur.setLastname(request.getParameter("lastname"));
                    updateFormateur.setEmail(request.getParameter("email"));
                    updateFormateur.setPassword(request.getParameter("password"));
                    updateFormateur.setId(Integer.parseInt(request.getParameter("id")));

                    FormateurServices formateurServices = new FormateurServices();
                    formateurServices.update(updateFormateur);

                    int promoId = Integer.parseInt(request.getParameter("promoId"));
                    if(promoId != 0) {
                        PromoServices promoServices = new PromoServices();
                        PromosEntity promo = promoServices.findById(promoId);
                        if(promo != null) {
                            int oldPromoId = promo.getFormateurId();
                            if(oldPromoId != updateFormateur.getId()) {
                                PromosEntity promoByFormateur = promoServices.findByFormateurId(updateFormateur.getId());
                                if(promoByFormateur != null) {
                                    promoByFormateur.setFormateurId(null);
                                    promoServices.update(promoByFormateur);
                                }

                            }
                            promo.setFormateurId(updateFormateur.getId());

                            promoServices.update(promo);

                        }

                    }
                }
            }

            response.sendRedirect("AdminServlet");

        }
    }
}
