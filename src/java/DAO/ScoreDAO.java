/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.HospitalScore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author adeen
 */
public class ScoreDAO {
    
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
    
    public void addScores (List<HospitalScore> p) throws Exception
    {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
           
            myConn = getConnection();
           
            String sql = "insert into hospitalscores"
                        + "(score,hospitalid,standardId,recommendation)"
                        + "values (?,?,?,?)";
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            for(int i=0; i<p.size(); i++){
                
            ps.setString(1, p.get(i).getScore());
            ps.setInt(2,Integer.parseInt(p.get(i).getHospitalId()));
            ps.setInt(3, p.get(i).getStandardId());
            ps.setString(4, p.get(i).getRecommendation());
                   
            //execute query
              int row  = ps.executeUpdate();
                
            }
            
            //return row;

        } finally {
            close(myConn, stmt, rs);
        }
    }
    
    
}
