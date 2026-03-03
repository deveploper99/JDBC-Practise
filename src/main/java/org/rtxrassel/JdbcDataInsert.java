package org.rtxrassel;

import java.sql.*;
import java.util.Scanner;

public class JdbcDataInsert {
   public static void main(String[] args) throws ClassNotFoundException  {

       Scanner input = new Scanner(System.in);
       System.out.print("Enter Your Name: ");
       String name = input.nextLine();

       System.out.print("Enter Your Roll: ");
       int roll = input.nextInt();


       System.out.print("Enter Your Email: ");
       String email = input.nextLine();
       input.nextLine();

       System.out.print("Enter Your Phone: ");
       String phone = input.nextLine();

       System.out.print("Enter Your cgpa: ");
       double cgpa = input.nextDouble();


       String url = "jdbc:mysql://localhost:3306/Student";
       String userName = "root";
       String passWord = "Rassel1122#";
       String query = "INSERT INTO students(name, roll, email, phone, cgpa) VALUES ("+ "'" + name + "', "+ roll + ", "+ "'" + email + "', " + "'" + phone + "', " + cgpa + ")";


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
