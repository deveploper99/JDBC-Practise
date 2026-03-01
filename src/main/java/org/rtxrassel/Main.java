package org.rtxrassel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main(String[] args) {

       String url = "jdbc:mysql://localhost:3306/?useSSL=false";
       String user = "root";
       String password = "Rassel1122#";
       try (Connection conn = DriverManager.getConnection(url, user, password)) {
           System.out.println("কানেকশন সাকসেসফুল! MySQL-এ কানেক্ট হয়েছে।");
       } catch (SQLException e) {
           System.out.println("এরর: " + e.getMessage());
           e.printStackTrace();
       }
    }
}
