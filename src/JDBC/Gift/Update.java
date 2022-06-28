package JDBC.Gift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        try{Class.forName("com.mysql.cj.jdbc.Driver");
            Connection comn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/NIIT","root","");
            Statement statement = comn.createStatement();
            statement.executeUpdate("INSERT INTO persons VALUES (1, 'Zara', 'Ali'),(2,'Kingsley','Coleman')");
            statement.executeUpdate("INSERT INTO persons VALUES (3, 'Raheem', 'Sterling'),(4,'Harry','Styles')");
            System.out.println("Database is connected ! ");

            comn.close();
        }catch (Exception e){
            System.out.println("Database was unable to connect");
            e.printStackTrace();
        }

    }
}
