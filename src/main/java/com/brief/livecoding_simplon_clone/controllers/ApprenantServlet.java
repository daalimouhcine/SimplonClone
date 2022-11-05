package com.brief.livecoding_simplon_clone.controllers;

import com.brief.livecoding_simplon_clone.entities.ApprenantEntity;
import com.brief.livecoding_simplon_clone.entities.PromosEntity;
import com.brief.livecoding_simplon_clone.entities.PromostoapprenantEntity;
import com.brief.livecoding_simplon_clone.services.ApprenantService;
import com.brief.livecoding_simplon_clone.services.PromoServices;
import com.brief.livecoding_simplon_clone.services.PromostoapprenantService;
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
                case "edit" -> {
                    ApprenantService apprenantService = new ApprenantService();
                    PromostoapprenantService promostoapprenantService = new PromostoapprenantService();
                    PromoServices promoServices = new PromoServices();

                    ApprenantEntity selectedApprenant = apprenantService.findById(Integer.parseInt(request.getParameter("id")));
                    PromostoapprenantEntity promoToApprenant = promostoapprenantService.findByApprenantId(selectedApprenant.getId());
//                    System.out.println(promoToApprenant.getPromoId());
                    List<PromosEntity> promosList = promoServices.getAll();

                    request.setAttribute("selectedApprenant", selectedApprenant);
                    if(promoToApprenant != null) {
                        request.setAttribute("promoToApprenant", promoToApprenant);
                    }
                    request.setAttribute("promosList", promosList);

                    request.getRequestDispatcher("updateApprenant.jsp").forward(request, response);
                }
                case "update" -> {
                    ApprenantService apprenantService = new ApprenantService();
                    PromostoapprenantService promostoapprenantService = new PromostoapprenantService();

                    ApprenantEntity updateApprenant = new ApprenantEntity();
                    updateApprenant.setId(Integer.parseInt(request.getParameter("id")));
                    updateApprenant.setFirstname(request.getParameter("firstname"));
                    updateApprenant.setLastname(request.getParameter("lastname"));
                    updateApprenant.setEmail(request.getParameter("email"));
                    updateApprenant.setPassword(request.getParameter("password"));

                    apprenantService.update(updateApprenant);

                    if(request.getParameter("promo") != null) {
                        System.out.println(request.getParameter("promo"));
                        PromostoapprenantEntity promostoapprenant = promostoapprenantService.findByApprenantId(updateApprenant.getId());

                        if(promostoapprenant == null) {
                            PromostoapprenantEntity newPromotoapprenant = new PromostoapprenantEntity();
                            newPromotoapprenant.setApprenantId(updateApprenant.getId());
                            newPromotoapprenant.setPromoId(Integer.parseInt(request.getParameter("promo")));
                            promostoapprenantService.add(newPromotoapprenant);
                        } else {
                            if(promostoapprenant.getApprenantId() != updateApprenant.getId()) {
                                PromostoapprenantEntity updatePromotoapprenant = new PromostoapprenantEntity();
                                updatePromotoapprenant.setApprenantId(updateApprenant.getId());
                                updatePromotoapprenant.setPromoId(Integer.parseInt(request.getParameter("promo")));
                                promostoapprenantService.update(updatePromotoapprenant);
                            }

                        }

//                        PromostoapprenantEntity promoToApprenant = new PromostoapprenantEntity();
//                        promoToApprenant.setApprenantId(updateApprenant.getId());
//                        promoToApprenant.setPromoId(Integer.parseInt(request.getParameter("promo")));
                    }

                }


            }

        }
//        doGet(request,response);
        response.sendRedirect("AdminServlet");

    }
}
