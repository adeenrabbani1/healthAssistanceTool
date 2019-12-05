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
import org.jboss.weld.servlet.SessionHolder;

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

        String command = isAdmin(request, response);
        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //CHECH SESSION HERE IN THE SWITCH STATEMENT BEFORE SERVING 
        // THE PAGES TO THE USER.
        //IF THERE IS NO SESSION, SYSTEM MUST RENDER THE LOGIN PAGE!
        String command = isAdmin(request, response);

        switch (command) {
            //later add router that serves the page
            case "ADD-ADMIN": {
                addAdmin(request, response);
                break;
            }
            case "ADD-SURVEYOR": {
                addSurveyor(request, response);
                break;
            }
            case "HOME": {
                //serve up the home page function here
                break;
            }
            case "assign": {
                assignHospital(request, response);
                break;
            }
            case "delete": {
                deleteHospital(request, response);
                break;
            }
            case "update": {
                updateHospitalAll(request, response);
                break;
            }
            case "adminDashboard": {
                viewDashboard(request, response);
                break;
            }
        }

    }

    private String isAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = null;
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") != null) {
            if (session.getAttribute("user").getClass().toString().equals("class entity.Admin")) {
                if (request.getAttribute("command") == null) {
                    command = (String) request.getParameter("command");
                } else if (request.getParameter("command") == null) {
                    command = (String) request.getAttribute("command");
                } else {
                    command = "HOME";
                }
            } else {
                response.sendRedirect("");
            }
        } else {
            response.sendRedirect("/");
        }
        return command;
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

    //assign hospital
    private void assignHospital(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int i = 0;
            String surID;
            HttpSession session = request.getSession(true);
            List<Hospital> hospitals = null;
            hospitals = (List<Hospital>) session.getAttribute("hospitals");
            for (; hospitals.size() > i; i++) {
                if (request.getParameter("dirPhone").equals(hospitals.get(i).getDirectorPhone())) {
                    break;
                }
            }
            surID = request.getParameter("sur");

            session.removeAttribute("hospitals");
            hospitals = new HospitalDAO().fetchHospital();
            session.setAttribute("hospitals", hospitals);
            new HospitalDAO().updateHospital(hospitals.get(i), surID);
            session.setAttribute("flash", "assigned");
            response.sendRedirect("admin/dashboard.jsp");
        } catch (Exception ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //delete hospital
    private void deleteHospital(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int i = 0;
            HttpSession session = request.getSession(true);
            List<Hospital> hospitals = null;
            hospitals = (List<Hospital>) session.getAttribute("hospitals");
            for (; hospitals.size() > i; i++) {
                if (request.getParameter("dirPhone").equals(hospitals.get(i).getDirectorPhone())) {
                    break;
                }
            }
            new HospitalDAO().deleteHospital(hospitals.get(i));
            session.removeAttribute("hospitals");
            hospitals = new HospitalDAO().fetchHospital();
            session.setAttribute("hospitals", hospitals);
            session.setAttribute("flash", "deleted");
            response.sendRedirect("admin/dashboard.jsp");
        } catch (Exception ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //update Hospital
    private void updateHospitalAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int i = 0;
            HttpSession session = request.getSession(true);
            List<Hospital> hospitals = null;
            hospitals = (List<Hospital>) session.getAttribute("hospitals");
            for (; hospitals.size() > i; i++) {
                if (request.getParameter("dirPhone").equals(hospitals.get(i).getDirectorPhone())) {
                    break;
                }
            }

            new HospitalDAO().updateHospitalAll(hospitals.get(i), request);
            session.removeAttribute("hospitals");
            hospitals = new HospitalDAO().fetchHospital();
            session.setAttribute("hospitals", hospitals);
            session.setAttribute("flash", "updated");
            response.sendRedirect("admin/dashboard.jsp");
        } catch (Exception ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //view Dashboard
    private void viewDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Hospital> hospitals = new HospitalDAO().fetchHospital();
            List<Surveyor> surveyors = new SurveyorDAO().fetchSurveyor();
            HttpSession session = request.getSession(true);
            session.setAttribute("hospitals", hospitals);
            session.setAttribute("surveyors", surveyors);
            response.sendRedirect("admin/dashboard.jsp");
        } catch (Exception ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Registering new sereyors!
    private void addSurveyor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //creating Surveyor DAO object to use the functionality!
        SurveyorDAO survdb = new SurveyorDAO();
        PrintWriter out = response.getWriter();
        String name = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        String phone = (String) request.getParameter("phone");
        String password = (String) request.getParameter("password");
        String age = request.getParameter("age");

        //new suveyor object
        Surveyor surv = new Surveyor(0, name, email, phone, age, "surveyor", password);
        surv.setRole("surveyor");
        //pass to DAO
        int row = 0;
        try {
            row = survdb.addSurveyor(surv);
        } catch (Exception ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (row > 0) {

            out.println("data has been added");

        }

    }

    //for viewing all the registered admins
    private void viewAdmins(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        AdminDAO admindb = new AdminDAO();
        List<Admin> admins = admindb.fetchAdmins();

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
