package org.rtxrassel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteValue {
   public static void main(String[] args) throws ClassNotFoundException {

       String url = "jdbc:mysql://localhost:3306/Student";
       String userName = "root";
       String passWord = "Rassel1122#";
       String query = "DELETE FROM students WHERE id = 5;";

       try(Connection con = DriverManager.getConnection(url,userName,passWord)) {
           System.out.println("Connection Successfully");

           Statement stmt = con.createStatement();
           int rowsAffected = stmt.executeUpdate(query);
           if (rowsAffected>0) System.out.println("Delete Successfull");
           else System.out.println("Not Deleted ");

       }catch (SQLException e){
           System.out.println("Database Connection Failed?"+e.getMessage());
       }

    }
}
