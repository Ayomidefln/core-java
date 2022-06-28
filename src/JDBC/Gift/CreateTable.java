package JDBC.Gift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try{Class.forName("com.mysql.cj.jdbc.Driver");
            Connection comn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/NIIT","root","");
            Statement statement = comn.createStatement();
            statement.executeUpdate("CREATE TABLE persons" +
                    "(user_id int, firstName varchar(25), lastName varchar(25) );");
            System.out.println("Database is connected ! ");

            comn.close();
        }catch (Exception e){
            System.out.println("Database was unable to connect");
            e.printStackTrace();
        }

    }
}
