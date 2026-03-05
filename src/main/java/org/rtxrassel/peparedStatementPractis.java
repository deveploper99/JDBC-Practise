package org.rtxrassel;

import java.sql.*;

public class peparedStatementPractis {
    static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/Student";
        String userName = "root";
        String password = "Rassel1122#";
        String query = "INSERT INTO students(name,roll,email,phone,cgpa) VALUES (?,?,?,?,?)";

        try {
            Connection con = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection Successfully");
            PreparedStatement pstm = con.prepareStatement(query);
           pstm.setString(1,"RasselHassan");
           pstm.setInt(2,7);
           pstm.setString(3,"rtx@gmail.com");
           pstm.setString(4,"0918327366");
           pstm.setDouble(5,4.33);

           int rowsAffected = pstm.executeUpdate();

           if (rowsAffected>0){
               System.out.println("data insert Successfully");
           }else System.out.println("data not insert failed");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
