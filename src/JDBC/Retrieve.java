package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Retrieve {
    public static void main(String[] args) {
        try{Class.forName("com.mysql.cj.jdbc.Driver");
            Connection comn = null;
            comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NIIT","root","");
            System.out.println("Database is connected ! ");

            String query = "select * from user";
            PreparedStatement statement = comn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String email = resultSet.getString("email");
                boolean male = resultSet.getBoolean("male");

                System.out.printf("%-10s%-20s%-20s%-10s\n", id, name, email, male);
            }
            comn.close();
        }catch (Exception e){
            System.out.println("Database was unable to connect");
            e.printStackTrace();
        }
    }
}
