package com.company.controller.servlet;

import com.company.model.dao.PaymentDAO;
import com.company.model.entity.payment.Payment;
import com.company.model.entity.wallet.Wallet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import static com.company.controller.servlet.Constants.*;

public class UserPayments extends HttpServlet {

    private int currentPage = 1;
    private static final PaymentDAO paymentDao = new PaymentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null){
            Wallet wallet = (Wallet) session.getAttribute(USER);
            List<Payment> payments = pagination(req, wallet);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/internet_provider/userPayments.jsp");
            dispatcher.forward(req,resp);
        }else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/internet_provider/errorPage.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private List<Payment> pagination(HttpServletRequest req,Wallet wallet){
        int ticketAmount = paymentDao.amountTickets(wallet.getId());
        int pageAmount = (int) Math.ceil((double) ticketAmount / PAYMENTS_LIMIT);

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

        int offset = (currentPage - 1) * PAYMENTS_LIMIT;
        List<Payment> payments = paymentDao.getUserPayments(wallet.getId(), offset, PAYMENTS_LIMIT);

        req.setAttribute(CURRENT_PAGE, currentPage);
        req.setAttribute(PAGES, pages);
        req.setAttribute(FIRST_PAGE, CONST_ONE);
        req.setAttribute(LAST_PAGE, pageAmount);

        return payments;
    }
}
