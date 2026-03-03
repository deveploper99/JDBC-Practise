package org.rtxrassel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateValue {
   public static void main(String[] args) {

       String url = "jdbc:mysql://localhost:3306/Student";
       String userName  = "root";
       String pass = "Rassel1122#";
       String query = "UPDATE students SET email = 'rayhan@gmail.com', cgpa = 4.00 WHERE id = 6;";

       try(Connection con = DriverManager.getConnection(url,userName,pass)) {
           System.out.println("Connection success");
           Statement stmt = con.createStatement();
           int result = stmt.executeUpdate(query);
           if (result>0) System.out.println("data update successfull");
           else System.out.println("update failed");

       }catch (SQLException e){
           System.out.println("Connection Failed: "+e.getMessage());
       }

    }
}
