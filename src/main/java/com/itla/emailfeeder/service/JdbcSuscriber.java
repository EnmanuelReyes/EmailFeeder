package com.itla.emailfeeder.service;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pimp on 17/05/2014.
 */
public class JdbcSuscriber {

    private static Connection connection = ConnManager.getConnection();

    String setSuscriberSQL = "INSERT INTO emails(email) values (?)";
    String getAllSuscriberSQL = "SELECT * FROM emails";

    public void addSuscriber(String email) {
        try {
            PreparedStatement ps = connection.prepareStatement(setSuscriberSQL);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

    }

    public List<String> getAllSuscriber() {
        List<String> listSuscriber = new ArrayList<String>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getAllSuscriberSQL);
            while (rs.next()) {
                    listSuscriber.add(rs.getString(2));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSuscriber;
    }

    public static void main(String[] args) {
        JdbcSuscriber test = new JdbcSuscriber();

        for (int i = 0; i < test.getAllSuscriber().size(); i++) {
            System.out.println(test.getAllSuscriber().get(i));
        }

    }


}
