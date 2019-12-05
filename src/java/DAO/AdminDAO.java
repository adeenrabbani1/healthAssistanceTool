/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.xml.ws.api.message.Packet;
import entity.Admin;
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
public class AdminDAO {

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
     //connectivity object for jdbc

    public Admin addAdmin(Admin admin) throws Exception {

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // get a connection
            myConn = getConnection();
            // create sql statement
            String sql = "insert into admin "
                    + "(name,email,age,phone,password,role,can_assign,can_add_admin,can_add_surveyor,can_view_result) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getAge());
            ps.setString(4, admin.getPhone());
            ps.setString(5, admin.getPassword());
            ps.setString(6, admin.getRole());
            ps.setInt(7, admin.getFlagCanAssign());
            ps.setInt(8, admin.getFlagCanAddAdmin());
            ps.setInt(9, admin.getFlagCanAddSurveyor());
            ps.setInt(10, admin.getFlagCanViewResult());

            //execute query
            ps.executeUpdate();

        } finally {

            close(myConn, stmt, rs);
        }
        return admin;
    }

    public List<Admin> fetchAdmins() throws SQLException, Exception {
        //list of admins to hold the values fetched from the database
        List<Admin> admins = new ArrayList<>();
        Connection myConn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            // get a connection
            myConn = getConnection();
            // create sql statement
            String sql = "SELECT * FROM admin";
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("admin_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                int canAssign = rs.getInt("can_assign");
                int canAddA = rs.getInt("can_add_admin");
                int canAddS = rs.getInt("can_add_surveyor");
                int canView = rs.getInt("can_view_result");
                admins.add(new Admin(id, canAssign, canAddA, canAddS, canView, name, email, phone, "admin", age, password));
            }

        } finally {
            close(myConn, stmt, rs);
        }
        return admins;
    }

}
