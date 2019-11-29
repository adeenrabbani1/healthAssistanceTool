/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Admin;
import entity.Hospital;
import entity.Surveyor;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
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

                Class.forName("com.mysql.jdbc.Driver");
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
                    role = rs.getString("role");
                    if (role.equals("admin")) {
                        id = "admin_id";
                        dashboard = "adminController";
                    } else if (role.equals("surveyor")) {
                        id = "surv_id";
                        dashboard = "surveyorController";
                    } else if (role.equals("hospital")) {
                        id = "hospital_id";
                        dashboard = "hospitalController";
                    }
                    sql = "SELECT * FROM " + role + " WHERE " + id + " = '" + rs.getString(id) + "'";
                    rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        if (rs.getString("role").equals("admin")) {
                            int assign, addAdmin, addSyr, showRes, idAdmin;
                            assign = rs.getString("can_assign").equals("1") ? 1 : 0;
                            addAdmin = rs.getString("can_add_admin").equals("1") ? 1 : 0;
                            addSyr = rs.getString("can_add_surveyor").equals("1") ? 1 : 0;
                            showRes = rs.getString("can_view_result").equals("1") ? 1 : 0;
                            idAdmin = Integer.parseInt(rs.getString(id),10);
                            Admin admin = new Admin(idAdmin, assign, addAdmin, addSyr, showRes, rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("age"), rs.getString("role"), "Don't Even Try");
                            HttpSession session = request.getSession(true);
                            session.setAttribute("admin", admin);
                            request.setAttribute("command", "adminDashboard");
                        
                        }else if (rs.getString("role").equals("surveyor")) {
                            int idSer;
                            idSer = Integer.parseInt(rs.getString(id), 10);
                            Surveyor surveyor = new Surveyor(idSer, rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("age"), rs.getString("role"), "Don't Even Try");
                            HttpSession session = request.getSession(true);
                            session.setAttribute("surveyor", surveyor);
                            
                        }else if (rs.getString("role").equals("hospital")) {
                            int idHos;
                            idHos = Integer.parseInt(rs.getString(id), 10);
                            Hospital hospital = new Hospital(idHos, rs.getString("name"), rs.getString("phone"), rs.getString("license_num"), rs.getString("address"), rs.getString("country"), Integer.parseInt(rs.getString("num_of_beds"),10), 
                                    Integer.parseInt(rs.getString("num_of_patients"),10), Integer.parseInt(rs.getString("num_of_out_patient"), 10), Integer.parseInt(rs.getString("num_of_in_patient"), 10), rs.getString("director_name"), 
                                    rs.getString("director_email"), rs.getString("director_phone"));
                            HttpSession session = request.getSession(true);
                            session.setAttribute("hospital", hospital);
                        }
                    }
                }
                // Close all the connections 
                con.close();
                RequestDispatcher rd = request.getRequestDispatcher(dashboard);
                rd.forward(request, response);
            } catch (Exception e) {
                out.println(e);
            }
            
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
