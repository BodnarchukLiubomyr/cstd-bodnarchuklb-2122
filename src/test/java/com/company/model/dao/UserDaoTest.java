package com.company.model.dao;

import com.company.model.MySQLConnector;
import com.company.model.entity.user.Role;
import com.company.model.entity.user.User;
import com.company.model.entity.user.UserDetails;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

public class UserDaoTest {
    public static final String DB_URL_TEST = "jdbc:mysql://localhost:3306/internet_providerTest?user=root&password=vorona2017V&serverTimezone=UTC";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/internet_provider?user=root&password=vorona2017V&serverTimezone=UTC";
    private static Properties properties;
    private static Connection connection;

    @Test
    public void getUserTest() {
        User user = new User();
        User userTest = null;
        UserDetails userDetails = new UserDetails();
        user.setLogin("test");
        user.setPassword("test");
        user.setRole(Role.USER);
        userDetails.setFirstnameEn("testUser");
        userDetails.setLastnameEn("testLast");
        userDetails.setEmail("test@test.com");
        userDetails.setPhone("123456789");
        user.setDetails(userDetails);
        UserDAO userDAO = new UserDAO();
        userDAO.insertUser(user);
        try {
            userTest = userDAO.getUser("test");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertEquals(user.getDetails().getFirstnameEn(), userTest.getDetails().getLastnameEn());
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

