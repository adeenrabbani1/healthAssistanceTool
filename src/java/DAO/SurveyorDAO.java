/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.Surveyor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adeen
 */
public class SurveyorDAO {
    
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
    
    public int addSurveyor(Surveyor surv) throws Exception{
       
       
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
           
            myConn = getConnection();
           
            String sql = "insert into surveyor "
                        + "(name,email,password,phone,age,role) "
                        + "values (?,?,?,?,?,?)";
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, surv.getName());
            ps.setString(2, surv.getEmail());
            ps.setString(3, surv.getPassword());
            ps.setString(4, surv.getPhone());
            ps.setString(5, surv.getAge());
            ps.setString(6, surv.getRole());          
            //execute query
            int row  = ps.executeUpdate();
            return row;

        } finally {
            close(myConn, stmt, rs);
        }
       
    }
    
    public List<Surveyor> fetchSurveyor() throws SQLException, Exception{
        //list of admins to hold the values fetched from the database
        List <Surveyor> surveyors = new ArrayList<>();
        Connection myConn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
             // get a connection
            myConn = getConnection();
            // create sql statement
            String sql = "SELECT * FROM surveyor";
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("surv_id");
                String name = rs.getString("name");
                String email= rs.getString("email");
                String role = rs.getString("role");
                String phone = rs.getString ("phone");
                String password = "Don't even try";
                String age = rs.getString("age");
               surveyors.add(new Surveyor(id, name, email, phone, age, role, password)); 
            }
           
        } finally{
             close(myConn, stmt, rs);
        }
        return surveyors;
    }
    
    
    
    
    
}
