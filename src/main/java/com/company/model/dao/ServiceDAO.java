package com.company.model.dao;

import com.company.model.MySQLConnector;
import com.company.model.entity.place.Place;
import com.company.model.entity.service.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.company.model.dao.SQL.*;

public class ServiceDAO {
    public void insertService(Service service){
        PreparedStatement pStatement = null;
        try (Connection connection = MySQLConnector.getConnection() ){
            pStatement = connection.prepareStatement(INSERT_SERVICE);
            pStatement.setString(1,service.getService_en());
            pStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            close(pStatement);
        }
    }
    public Service selectService(int id){
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        Service service = new Service();
        try (Connection connection = MySQLConnector.getConnection() ){
            pStatement = connection.prepareStatement(SELECT_SERVICE);
            pStatement.setInt(1,id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()){
                mapService(service,resultSet);
            }
            else{
                throw new SQLException("Service isn`t found");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            close(pStatement);
            close(resultSet);
        }
        return service;
    }

    public List<Service> selectServices() {
        List<Service> services = new ArrayList<>();
        Service service = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try (Connection connection = MySQLConnector.getConnection() ){
            pStatement = connection.prepareStatement(SELECT_SERVICES);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                service = new Service();
                mapService(service, resultSet);
                services.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(pStatement);
        }
        return services;
    }


    public void mapService(Service service, ResultSet resultSet) throws SQLException {
        service.setId(resultSet.getInt("id"));
        service.setService_en(resultSet.getString("service_en"));
    }

    public void close(AutoCloseable closeable){
        if (closeable != null){
            try {
                closeable.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
