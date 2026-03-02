package org.rtxrassel;

import java.sql.*;

public class JdbcDataInsert {
   public static void main(String[] args) throws ClassNotFoundException  {

       String url = "jdbc:mysql://localhost:3306/Student";
       String userName = "root";
       String passWord = "Rassel1122#";
       String query = "INSERT INTO students(name,roll,email,phone,cgpa) VALUES ('Mahadi',5,'mahadi@gmail.com','0173476337',4.89);";

       try(Connection con = DriverManager.getConnection(url,userName,passWord)) {
           System.out.println("Database Connection Successfully");
           Statement stmt = con.createStatement();
           int rowsAffected = stmt.executeUpdate(query);
           if (rowsAffected>0){
               System.out.println("Insert Successfully"+rowsAffected+" row`s affected");
           }else System.out.println("Insertion failed");

           con.close();
           stmt.close();


       }catch (SQLException e){
           System.out.println("Database Error"+e.getMessage());
       }




    }
}
