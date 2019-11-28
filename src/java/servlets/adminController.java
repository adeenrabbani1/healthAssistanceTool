/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import entity.Surveyor;
import DAO.SurveyorDAO;
import DAO.AdminDAO;
import DAO.HospitalDAO;
import entity.Admin;
import entity.Hospital;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adeen
 */
@WebServlet(name = "adminController", urlPatterns = {"/adminController"})
public class adminController extends HttpServlet {

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

        //CHECH SESSION HERE IN THE SWITCH STATEMENT BEFORE SERVING 
        // THE PAGES TO THE USER.
        //IF THERE IS NO SESSION, SYSTEM MUST RENDER THE LOGIN PAGE!

        String command = (String) request.getAttribute("command");

        if (command == null) {
            command = "HOME";
        }

        switch (command) {
            //later add router that serves the page
            case "ADD-ADMIN": {
                addAdmin(request, response);
                break;
            }
            
            case "ADD-SURVEYOR":{
                addSurveyor(request,response);
                break;
            }
            case "HOME":{
                
                //serve up the home page function here
                break;
            }
            case "VIEW-ADMINS":{
                
               // viewAdmins(request, response);
                break;
            }
            case "adminDashboard":{
                
                try {
                    List <Hospital> hospitals = new HospitalDAO().fetchHospital();
                    List <Surveyor> surveyors = new SurveyorDAO().fetchSurveyor();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("hospitals", hospitals);
                    session.setAttribute("surveyors", surveyors);
                    RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard.jsp");
                    rd.forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
        }
        
    }

    //do the admin registeration thing here
    private void addAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //admin dao obj to access the admin database.
       
        AdminDAO admindb = new AdminDAO();
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("admin_id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        int canAssign = Integer.parseInt(request.getParameter("canAssign"));
        int canRegisterA = Integer.parseInt(request.getParameter("canRegisterAdmin"));
        int canRegisterS = Integer.parseInt(request.getParameter("canRegisterSurveyor"));
        int canSeeResult = Integer.parseInt(request.getParameter("canSeeResults"));

        Admin newAdmin = new Admin(id, canAssign, canRegisterA, canRegisterS, canSeeResult, name, email, phone, "admin", age, password);

        try {
            Admin add = admindb.addAdmin(newAdmin);

        } catch (Exception ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // Registering new sereyors!
    
    private void addSurveyor(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        
        
        //creating Surveyor DAO object to use the functionality!
        SurveyorDAO survdb = new SurveyorDAO();
        PrintWriter out = response.getWriter();
          String name = (String) request.getParameter("name");
          String email = (String) request.getParameter("email");
          String phone = (String) request.getParameter("phone");
          String password = (String) request.getParameter("password");
          String age = request.getParameter("age");
          
          //new suveyor object
          Surveyor surv = new Surveyor(0, name, email, phone, age,"surveyor", password);
          surv.setRole("surveyor");
          //pass to DAO
        int row = 0;
        try {
            row = survdb.addSurveyor(surv);
        } catch (Exception ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(row > 0){
             
             out.println("data has been added");
             
         }
          
        
    }
    
    
    //for viewing all the registered admins
    
    private void viewAdmins(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception{
        
       AdminDAO admindb = new AdminDAO();
       List<Admin> admins =  admindb.fetchAdmins();
        
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
