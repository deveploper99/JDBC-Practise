package org.rtxrassel;


import java.sql.*;


public class Main {
   public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Student";
        String userName = "root";
        String passWord = "Rassel1122#";
        String query = "SELECT*FROM students;";

        try(Connection con = DriverManager.getConnection(url,userName,passWord)) {
            System.out.println("Connection successfully");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int roll = resultSet.getInt("roll");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                double cgpa = resultSet.getDouble("cgpa");

                System.out.println(" ");

                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Roll: "+roll);
                System.out.println("Email: "+email);
                System.out.println("Phone: "+phone);
                System.out.println("CGPA: "+cgpa);

                System.out.println("===============");

            }
            con.close();
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(" Database Error"+e.getMessage());
        }



    }
}
