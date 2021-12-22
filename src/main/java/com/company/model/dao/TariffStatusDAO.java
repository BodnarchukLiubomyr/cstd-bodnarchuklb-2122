package com.company.model.dao;

import com.company.model.MySQLConnector;
import com.company.model.entity.service.Service;
import com.company.model.entity.tariff.TariffStatus;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.company.model.dao.SQL.*;


public class TariffStatusDAO {
    public void insertStatus(TariffStatus status){
        PreparedStatement preparedStatement = null;
        try (Connection connection = MySQLConnector.getConnection() ){
            preparedStatement = connection.prepareStatement(INSERT_TARIFF_STATUS);
            preparedStatement.setString(1,status.getStatus_en());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
        }
    }

    public List<TariffStatus> selectStatuses() {
        List<TariffStatus> statuses = new ArrayList<>();
        TariffStatus status = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try (Connection connection = MySQLConnector.getConnection() ){
            pStatement = connection.prepareStatement(SELECT_TARIFF_STATUSES);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                status = new TariffStatus();
                mapStatus(status, resultSet);
                statuses.add(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(pStatement);
        }
        return statuses;
    }


    public TariffStatus selectStatus(int id){
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        TariffStatus status = new TariffStatus();
        try (Connection connection = MySQLConnector.getConnection() ){
            pStatement = connection.prepareStatement(SELECT_TARIFF_STATUS);
            pStatement.setInt(1,id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()){
                mapStatus(status,resultSet);
            }
            else{
                throw new SQLException("Status isn`t found");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            close(pStatement);
            close(resultSet);
        }
        return status;
    }

    public void mapStatus(TariffStatus status, ResultSet resultSet) throws SQLException {
        status.setId(resultSet.getInt("id"));
        status.setStatus_en(resultSet.getString("status_en"));
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
