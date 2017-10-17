package testdatabase3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.sql.Connection;
/**
 *
 * @author rdodg
 */
public class input_into_table {
    public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO Games (Name) " +
                        "VALUES (1, 'Mario Kart' );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Games (NAME) " +
                  "VALUES (2, 'Zelda' );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Games (NAME) " +
                  "VALUES (3, 'Halo );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Games (NAME) " +
                  "VALUES (4, 'Grand Theft Auto);"; 
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}

