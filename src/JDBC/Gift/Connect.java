package JDBC.Gift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    public static void main(String[] args) {
        try{Class.forName("com.mysql.cj.jdbc.Driver");
            Connection comn = null;
            comn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NIIT","root","");
            System.out.println("Database is connected ! ");
            comn.close();
        }catch (Exception e){
            System.out.println("Database was unable to connect");
            e.printStackTrace();
        }
    }
}
