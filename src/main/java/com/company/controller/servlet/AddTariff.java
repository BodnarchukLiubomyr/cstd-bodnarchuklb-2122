package com.company.controller.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

import com.company.model.dao.ServiceDAO;
import com.company.model.dao.TariffDAO;
import com.company.model.dao.TariffStatusDAO;
import com.company.model.entity.service.Service;
import com.company.model.entity.tariff.Tariff;
import com.company.model.entity.tariff.TariffStatus;

import static com.company.controller.servlet.Constants.*;

public class AddTariff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(SERVICES,ServletUtil.selectServices());
        req.setAttribute(STATUSES,ServletUtil.selectStatuses());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/internet_provider/addTariff.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceDAO serviceDAO = new ServiceDAO();
        TariffStatusDAO statusDAO = new TariffStatusDAO();
        if("add tariff".equals(req.getParameter("action"))){
            Tariff tariff = new Tariff();
            tariff.setName_en(req.getParameter("name_en"));
            tariff.setDescription(req.getParameter("description"));
            tariff.setPrice(new BigDecimal(req.getParameter("price")));
            tariff.setTime(Integer.parseInt(req.getParameter("time")));
            Service service = serviceDAO.selectService(Integer.parseInt(req.getParameter("service")));
            tariff.setService(service);
            TariffStatus status = statusDAO.selectStatus(Integer.parseInt(req.getParameter("status")));
            tariff.setStatus(status);
            new TariffDAO().insertTariff(tariff);
            resp.sendRedirect("/internet_provider/home");

        } else if("add service".equals(req.getParameter("action"))){
            Service service = new Service();
            service.setService_en(req.getParameter("service_en"));
            serviceDAO.insertService(service);
            resp.sendRedirect("/internet_provider/addTariff");
        }
        else if("add tariff_status".equals(req.getParameter("action"))){
            TariffStatus status = new TariffStatus();
            status.setStatus_en(req.getParameter("status_en"));
            statusDAO.insertStatus(status);
            resp.sendRedirect("/internet_provider/addTariff");
        }
    }
}
