package com.company.controller.servlet;

import com.company.model.dao.UserDAO;
import com.company.model.encryption.CryptPassword;
import com.company.model.entity.place.Place;
import com.company.model.entity.user.Role;
import com.company.model.entity.user.User;
import com.company.model.entity.user.UserDetails;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/internet_provider/registration.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        UserDetails details = new UserDetails();
        Place place = new Place();
        user.setLogin(req.getParameter("login"));
        try {
            String cryptPassword = CryptPassword.getSaltedHash(req.getParameter("password"));
            user.setPassword(cryptPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setRole(Role.USER);
        details.setFirstnameEn(req.getParameter("firstnameEn"));
        details.setLastnameEn(req.getParameter("lastnameEn"));
        details.setEmail(req.getParameter("email"));
        details.setPhone(req.getParameter("phone"));
        user.setDetails(details);
        place.setStreet(req.getParameter("street"));
        place.setDistrict(req.getParameter("district"));
        place.setCity(req.getParameter("city"));
        user.setPlace(place);
        new UserDAO().insertUser(user);
        resp.sendRedirect("/internet_provider/home");
    }
}
