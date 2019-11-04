/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adeen
 */
public class AdminDAO {
    
    
    private String url,use,password;
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
    private Connection getConnection () throws Exception {
        
          url = "jdbc:mysql://localhost:3306/hat?useTimezone=true&serverTimezone=UTC";
          use = "root";
          password = "";         
         Class.forName("com.mysql.jdbc.Driver");
         return DriverManager.getConnection(url, use, password);
        
    }
    
    
    
     
     //connectivity object for jdbc
    
    public Admin addAdmin (Admin admin) throws Exception {
       
        
        
        
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
           myConn = getConnection();
            // create sql statement
            String sql = "insert into admin "
                        + "(name,email,age,password,role,can_assign,can_add_admin,can_add_surveyor,can_view_result) "
                        + "values (?,?,?,?,?,?,?,?,?)";
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getAge());
            ps.setString(4, admin.getPassword());
            ps.setString(5, admin.getRole());
            ps.setInt(6, admin.getFlagCanAssign());
            ps.setInt(7, admin.getFlagCanAddAdmin());
            ps.setInt(8, admin.getFlagCanAddSurveyor());
            ps.setInt(9, admin.getFlagCanViewResult());


            //execute query
              ps.executeUpdate();
          
       
            

        } finally {
            
            close(myConn, stmt, rs);
        }
        return admin;
    }
}
    //close connection
//    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
//
//        try {
//            if (myRs != null) {
//                myRs.close();
//            }
//
//            if (myStmt != null) {
//                myStmt.close();
//            }
//
//            if (myConn != null) {
//                myConn.close();  
//            }
//        } catch (SQLException exc) {
//        }
//    }
//}
