package com.company.model.dao;

import com.company.model.MySQLConnector;
import com.company.model.entity.user.Role;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class RoleDaoTest {
    public static final String DB_URL_TEST = "jdbc:mysql://localhost:3306/internet_providerTest?user=root&password=vorona2017V&serverTimezone=UTC";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/internet_provider?user=root&password=vorona2017V&serverTimezone=UTC";
    private static Properties properties;
    private static Connection connection;

    @Test
    public void getRoleTest() {
        Role expected = Role.ADMIN;
        Role actual = new RoleDAO().getRole(1);
        assertSame(expected, actual);
    }

    @Test
    public void getRoleFiledTest() {
        Role expected = Role.ADMIN;
        Role actual = new RoleDAO().getRole(2);
        assertNotSame(expected, actual);
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

