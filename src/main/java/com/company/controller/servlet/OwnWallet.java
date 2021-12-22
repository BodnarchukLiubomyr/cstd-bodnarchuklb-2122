package com.company.controller.servlet;

import com.company.model.dao.UserDAO;
import com.company.model.entity.user.User;
import com.company.model.entity.wallet.Wallet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import static com.company.controller.servlet.Constants.*;


public class OwnWallet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Wallet wallet = new Wallet();
        if(session!=null){
            User user = (User) session.getAttribute(USER);
            req.setAttribute("funds",wallet.getFunds());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/internet_provider/ownWallet.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Wallet wallet = new Wallet();
        User user = new User();
        UserDAO dao = new UserDAO();
        try {
            dao.getUser(user.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/internet_provider/home");
    }
}
