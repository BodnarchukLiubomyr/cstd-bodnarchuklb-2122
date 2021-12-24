package com.company.controller.servlet;

import com.company.model.dao.ServiceDAO;
import com.company.model.dao.TariffDAO;
import com.company.model.entity.tariff.Tariff;
import com.company.model.entity.user.Role;
import com.company.model.entity.user.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.controller.servlet.Constants.*;

public class Home extends HttpServlet {

    private int currentPage = 1;
    private final TariffDAO tariffDAO = new TariffDAO();
    private final ServiceDAO serviceDAO = new ServiceDAO();
    private String sortedTariff  = "alphabet";
    private String showOnlyService = "All";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "tariffSelect";
        User user = null;
        if(req.getSession(false)!=null){
            user = (User) req.getSession(false).getAttribute(USER);
            req.setAttribute(USER,user);
            if(user != null){
                if(Role.ADMIN.equals(user.getRole())){
                    link = "editTariff";
                }
            }
        }

        List<Tariff> tariffs;

        if (showOnlyService.equals("All")) {
            tariffs = TariffDAO.selectTariffs();
        }
        List<Tariff> emptyFilms = new ArrayList<>();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/internet_provider/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        private List<Tariff> pagination(HttpServletRequest req, List<Tariff> tariffs) {
            int filmAmount = tariffs.size();

            Integer[] pages = new Integer[pageAmount];
            for (int i = 0; i < pageAmount; ++i) {
                pages[i] = i + 1;
            }

            if (req.getParameter("page") != null) {
                currentPage = Integer.parseInt(req.getParameter("page"));
                if (currentPage > pageAmount || currentPage < 1) {
                    currentPage = 1;
                }
            }
            return tariffs;
        }
    }
}
