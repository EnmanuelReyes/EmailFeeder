package com.itla.emailfeeder.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

/**
 * Created by Pimp on 15/05/2014.
 */
public class ConnManager {

    private static Connection connection;
    private static EntityManagerFactory entityManagerFactory;
    private static String url = "jdbc:mysql://localhost:3306/EMAILFEEDER";
    private static String user = "root";
    private static String pass = "password";

    private ConnManager() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("Conected!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("EmailPU");
        }

        return entityManagerFactory;
    }

    public static void main(String[] args) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from emails");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}