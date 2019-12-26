/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Hospital;
import entity.Standard;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adeen
 */
public class StandardDAO {

    //for database purpose.
    private String url, use, password;

    //mehtod for closing a jdbc connection!
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        } catch (SQLException exc) {
        }
    }

    //getting databse connection to work with! 
    private Connection getConnection() throws Exception {

        url = "jdbc:mysql://localhost:3306/hat?useTimezone=true&serverTimezone=UTC";
        use = "root";
        password = "";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, use, password);

    }

    public void addStandard(Standard std) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            myConn = getConnection();
            // create sql statement
            String sql = "insert into standards "
                    + "(code,domain,category,description,title) "
                    + "values (?,?,?,?,?)";
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, std.getCode());
            ps.setString(2, std.getDomain());
            ps.setString(3, std.getCategory());
            ps.setString(4, std.getDescription());
            ps.setString(5, std.getTitle());

            //execute query
            ps.executeUpdate();

        } finally {
            close(myConn, stmt, rs);
        }
    }
    
    public List<Standard> fetchStandards() throws Exception{
         Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List <Standard> std = new ArrayList<Standard>();
         try {
            // get a connection
            myConn = getConnection();
            //create sql statement
            String sql = "Select * FROM standards";
            // create prepared statement
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String category = rs.getString("category");
                String domain = rs.getString("domain");
                String description  = rs.getString("description");
                String title = rs.getString("title");
                
                Standard temp = new Standard(id, code,description,title,category, domain);
                
                std.add(temp);
            } 
                     
           }
        
          
         finally {
            close(myConn, stmt, rs);
        }
         
         return std; // returning the list of standards!!

    }
   


  
    
    
    public void deleteStandard(Standard std) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            myConn = getConnection();
            // create sql statement
            String sql = "delete from standards where code = ?";
            // create prepared statement
            stmt = myConn.createStatement();
            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, std.getCode());

            //execute query
            ps.executeUpdate();

        } finally {

            close(myConn, stmt, rs);
        }

    }
    
    public void updateStandard(HttpServletRequest req, String id) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            myConn = getConnection();
            // create sql statement
            String sql = "UPDATE standards SET code = ?,domain = ?,category = ?,description = ?,title = ? where id = ?";
            // create prepared statement
            stmt = myConn.createStatement();
            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, req.getParameter("code"));
            ps.setString(2, req.getParameter("domain"));
            ps.setString(3, req.getParameter("category"));
            ps.setString(4, req.getParameter("des"));
            ps.setString(5, req.getParameter("title"));
            ps.setString(6, id);
            
            //execute query
            ps.executeUpdate();

        } finally {

            close(myConn, stmt, rs);
        }

    }

}
