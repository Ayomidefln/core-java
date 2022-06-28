package JDBC.Batches;

import java.sql.*;

public class BookInfo {

    public void withStatement(){
        try{
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/books_db","root","");
            Statement stmt = con.createStatement();
            con.setAutoCommit(false);
            stmt.addBatch("INSERT INTO Books (book_id, book_name) VALUE('B004', 'Kane and Able')");
            stmt.addBatch("INSERT INTO Books (book_id, book_name) VALUE('B005', 'The Ghost')");
            stmt.addBatch("INSERT INTO Books (book_id, book_name) VALUE('B006', 'If Tomorrow Comes')");

            int[] results = stmt.executeBatch();
            System.out.println("");
            System.out.println("Using Statement object");
            System.out.println("-------------------------");
            for (int i = 0; i < results.length; i++){
                System.out.println("Rows affected by " + (i + 1) + "INSERT statement: " + results[i]);
            }
            con.commit();
            System.out.println("Statement Successful");

        } catch (Exception e){
            System.out.println("Statement Unsuccessful");
        }
    }

    public void withPreparedStatement(){
            try{
                Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/books_db","root","");
                con.setAutoCommit(false);
                PreparedStatement ps = con.prepareStatement("INSERT INTO Books (book_id, book_name) VALUE (?, ?)");
                System.out.println("");
                System.out.println("------------------------------");
                System.out.println("Using PreparedStatement object");
                System.out.println("------------------------------");

                ps.setString(1,"B007");
                ps.setString(2,"Book 1 name");
                ps.addBatch();

                ps.setString(1,"B008");
                ps.setString(2,"Book 2 name");
                ps.addBatch();

                int[] numUpdates = ps.executeBatch();
                for (int i = 0; i < numUpdates.length; i++){
                    System.err.println("Rows affected by " + (i + 1) + "INSERT statement: " + numUpdates[i]);
                }
                con.commit();
                System.out.println("Prepared Statement Successful");
            }catch (Exception bue){
                System.out.println("Error: " + bue);
                System.out.println("Prepared Statement Unsuccessful");
            }
    }

    public static void main(String[] args) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.withStatement();
        bookInfo.withPreparedStatement();
    }
}

