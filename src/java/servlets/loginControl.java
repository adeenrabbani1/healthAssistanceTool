/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SHERIF ABOUELMAGD
 */
@WebServlet(name = "loginControl", urlPatterns = {"/loginControl"})
public class loginControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String dashboard = "notfound.jsp";
            try {
                /* TODO output your page here. You may use following sample code. */
                // Initialize all the information regarding 
                // Database Connection 
                String dbDriver = "com.mysql.jdbc.Driver";
                String dbURL = "jdbc:mysql://localhost:3306/hat?useTimezone=true&serverTimezone=UTC";

                // Database name to access 
                String dbUsername = "root";
                String dbPassword = "";

                Class.forName(dbDriver);
                Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                // Create a SQL query to insert data into demo table 
                // demo table consists of two columns, so two '?' is used 
                // Execute SQL query
                String email = (String) request.getParameter("email");
                String password = (String) request.getParameter("password");
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM authentication WHERE email = '" + email + "' AND password = '" + password + "'";
                ResultSet rs = stmt.executeQuery(sql);

                //Variables for sql tables
                String id = null;
                String role;

                // Extract data from result set
                //Retrieve by column name
                //Display values
                if (rs.next() == true) {
                    out.println("I'm here if");
                    role = rs.getString("role");
                    out.println(role);
                    if (role.equals("admin")) {
                        out.println("I'm here");
                        id = "admin_id";
                        dashboard = "admin/dashboard.jsp";
                    } else if (role == "surveyor") {
                        id = "surv_id";
                        dashboard = "surveyor/dashboard.jsp";
                    } else if (role == "hospital") {
                        id = "hospital_id";
                        dashboard = "hospital/dashboard.jsp";
                    }
                    sql = "SELECT * FROM " + role + " WHERE " + id + " = '" + rs.getString(id) + "'";
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("name", rs.getString("name"));
                    session.setAttribute("role", role);
                    session.setAttribute("id", rs.getString(id));

                }
                // Close all the connections 
                con.close();
            } catch (Exception e) {
                out.println(e);
            }
            response.sendRedirect(dashboard);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
