package com.company.controller.servlet;

import com.company.model.dao.TariffDAO;
import com.company.model.entity.tariff.Tariff;
import com.company.model.entity.user.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static com.company.controller.servlet.Constants.USER;

public class SuggestTariffs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/internet_provider/suggestTariffs.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tariff tariff = new Tariff();
        User user = (User) req.getSession(false).getAttribute(USER);
        tariff.setName_en(req.getParameter("name_en"));
        tariff.setDescription(req.getParameter("description"));
        tariff.setPrice(new BigDecimal(req.getParameter("price")));
        tariff.setTime(Integer.parseInt(req.getParameter("time")));

        tariff.getName_en();
        tariff.getDescription();
        tariff.getPrice();
        tariff.getTime();
        tariff.getStatus();
        tariff.getService();
        try {
            new TariffDAO().selectTariff(tariff.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/internet_provider/home");
    }
}
