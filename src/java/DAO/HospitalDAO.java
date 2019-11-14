/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.Hospital;
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




public class HospitalDAO {
    //for database purpose.
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
    
    
    
    
    public int saveHospital(Hospital hos) throws Exception{
        
           
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
           myConn = getConnection();
            // create sql statement
            String sql = "insert into hospital "
                        + "(name,phone,license_num,address,country,num_of_beds,num_of_patients,num_of_out_patient,num_of_in_patient,director_name,director_email,director_phone)"
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, hos.getName());
            ps.setString(2, hos.getPhone());
            ps.setString(3, hos.getLicenseNum());
            ps.setString(4, hos.getAddress());
            ps.setString(5, hos.getCountry());
            ps.setInt(6, hos.getNumOfBeds());
            ps.setInt(7, hos.getNumOfPatients());
            ps.setInt(8, hos.getNumOfOutPatient());
            ps.setInt(9, hos.getNumOfInPatient());
            ps.setString(10, hos.getDirectorName());
            ps.setString(11, hos.getDirectorEmail());
            ps.setString(12, hos.getDirectorPhone());


            //execute query
             int row = ps.executeUpdate();
          
          return row;
            

        } finally {
            
            close(myConn, stmt, rs);
        }
        
    }
        
        
        
    }

