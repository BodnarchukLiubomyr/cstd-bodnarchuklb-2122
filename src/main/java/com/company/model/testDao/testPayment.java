package com.company.model.testDao;

import com.company.model.dao.PaymentDAO;
import com.company.model.dao.TariffDAO;
import com.company.model.dao.WalletDAO;
import com.company.model.entity.payment.Payment;

import java.math.BigDecimal;
import java.sql.SQLException;

public class testPayment {
    public static void main(String[] args) throws SQLException {
        Payment payment = new Payment();
        WalletDAO dao1 = new WalletDAO();
        payment.setWalletId(1);
        TariffDAO dao2 = new TariffDAO();
        payment.setPrice(new BigDecimal(150));
        PaymentDAO dao = new PaymentDAO();
        //dao.insertPayment(payment,3);
    }
}
