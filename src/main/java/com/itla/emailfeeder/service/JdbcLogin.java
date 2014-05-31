package com.itla.emailfeeder.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Pimp on 23/05/2014.
 */
public class JdbcLogin implements Login {

    private static Connection connection = ConnManager.getConnection();

    public  boolean authentificator(String user, String password) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admins");
            while (resultSet.next()) {
                if(resultSet.getString(2).equalsIgnoreCase(user) && resultSet.getString(3).equalsIgnoreCase(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
