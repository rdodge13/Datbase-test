/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatingsqlitedatabase;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class GetData {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\rdodg\\Desktop\\Ryan's School\\Sophmore Project\\SQLite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT id, name, capacity FROM warehouses";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GetData app = new GetData();
        app.selectAll();
    }
 
}