package com.company.model.dao;

import com.company.model.MySQLConnector;
import com.company.model.entity.service.Service;
import com.company.model.entity.tariff.TariffStatus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class StatusDaoTest {
    public static final String DB_URL_TEST = "jdbc:mysql://localhost:3306/internet_providerTest?user=root&password=vorona2017V&serverTimezone=UTC";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/internet_provider?user=root&password=vorona2017V&serverTimezone=UTC";
    private static Properties properties;
    private static Connection connection;

    @Test
    public void getGenreTest() {
        TariffStatus status = new TariffStatus();
        status.setStatus_en("TestService1");
        TariffStatusDAO statusDAO = new TariffStatusDAO();
        statusDAO.insertStatus(status);
        TariffStatus actual = statusDAO.selectStatus(6);
        assertEquals(status.getStatus_en(), actual.getStatus_en());
    }

    @BeforeClass
    public static void beforeTest() throws IOException, SQLException, ClassNotFoundException {

        properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/application.properties"));
        properties.setProperty("url", DB_URL_TEST);
        properties.store(new FileOutputStream("src/main/resources/application.properties"), null);

        connection = MySQLConnector.getConnection();
    }

    @AfterClass
    public static void afterTest() throws IOException {
        properties.setProperty("url", DB_URL);
        properties.store(new FileOutputStream("src/main/resources/application.properties"), null);
    }


}

