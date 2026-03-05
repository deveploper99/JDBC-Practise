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


            String selectQuery = "SELECT * FROM students";
            ResultSet result = pstm.executeQuery(selectQuery);
            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                int roll = result.getInt("roll");
                String email = result.getString("email");
                String phone = result.getString("phone");
                double cgpa = result.getDouble("cgpa");

                System.out.println(id+" | "+name+" | "+roll+" | "+email+" | "+phone+" | "+cgpa);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
