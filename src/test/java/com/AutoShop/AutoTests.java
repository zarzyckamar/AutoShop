package com.AutoShop;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class AutoTests {

    @Test
    public void connectWithDatabase() {
        String Url = "jdbc:postgresql://localhost:5432/database?user=admin&password=admin";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Url);
            System.out.println("Connection Established Successfull with DataBase: "
                    + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }

}
