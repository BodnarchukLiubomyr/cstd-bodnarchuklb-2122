package com.company.model.dao;

import com.company.model.MySQLConnector;
import com.company.model.entity.payment.Payment;
import com.company.model.entity.tariff.Tariff;
import com.company.model.entity.wallet.Wallet;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static com.company.model.dao.SQL.*;

public class PaymentDAO {
    public void insertPayment(Payment payment){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = MySQLConnector.getConnection();
            pStatement = connection.prepareStatement(INSERT_PAYMENT);
            pStatement.setInt(1,payment.getWalletId());
            pStatement.setInt(2,payment.getTariffId());
            pStatement.setBigDecimal(3,payment.getPrice());;
            pStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            close(connection);
            close(pStatement);
        }
    }
    public List<Payment> getUserPayments(int walletId, int offset, int limit) {
        List<Payment> paymentList = new LinkedList<>();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try (Connection connection = MySQLConnector.getConnection() ){
            pStatement = connection.prepareStatement(SELECT_USER_PAYMENTS_LIMIT);//////////////////////////////////
            pStatement.setInt(1,walletId);
            pStatement.setInt(2, offset);
            pStatement.setInt(3, limit);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()){
                Payment payment = new Payment();
                payment.setWalletId(resultSet.getInt("wallet_id"));
                payment.setTariffId(resultSet.getInt("tariff_id"));
                payment.setPrice(resultSet.getBigDecimal("price"));
                mapPayment(payment,resultSet);
                paymentList.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pStatement);
            close(resultSet);
        }
        return paymentList;
    }

    public int amountTickets(int walletId) {
        int amount = 0;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try (Connection connection = MySQLConnector.getConnection() ){
            pStatement = connection.prepareStatement(SELECT_AMOUNT_PAYMENTS);//////////////////////////////
            pStatement.setInt(1, walletId);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                amount = resultSet.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(pStatement);
        }
        return amount;
    }

    private void mapPayment(Payment payment,ResultSet resultSet) throws SQLException {
        Tariff tariff = new TariffDAO().selectTariff(payment.getTariffId());
        payment.setTariffName(tariff.getName_en());
        payment.setPrice(tariff.getPrice());
        payment.setTime(tariff.getTime());
    }

    public void close(AutoCloseable closeable){
        if(closeable != null){
            try {
                closeable.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
