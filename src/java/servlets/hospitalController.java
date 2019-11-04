/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import entity.Hospital;
import DAO.HospitalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adeen
 */
@WebServlet(name = "hospitalController", urlPatterns = {"/hospitalController"})
public class hospitalController extends HttpServlet {

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
        
       
        String command = request.getParameter("command");

        if (command == null) {
            command = "HOME";
        }

        switch (command) {
            //later set up a route that serves up the page
            case "APPLY": {
                hospitalApplication(request,response);
                break;
            }

           //later more commands put here
        }

    }

    private void hospitalApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HospitalDAO hdb = new HospitalDAO();
         PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String license = request.getParameter("license");
        String country = request.getParameter("country");
        String address = request.getParameter("address");
        int numBeds = Integer.parseInt(request.getParameter("numOfBeds"));
        int numPatient = Integer.parseInt(request.getParameter("numOfPatient"));
        int numInPat = Integer.parseInt(request.getParameter("numOfInPatient"));
        int numOutPat = Integer.parseInt(request.getParameter("numOfOutPatient"));
        String dname = request.getParameter("dname");
        String demail = request.getParameter("demail");
        String dphone = request.getParameter("dphone");
        
        Hospital hospital = new Hospital (0,name,phone,license,address,country,numBeds,numPatient,numOutPat,numInPat,dname,demail,dphone);
        out.print(hospital.toString());
        try {
           int row = hdb.saveHospital(hospital);
           
           out.print(row);
        } catch (Exception ex) {
            Logger.getLogger(hospitalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
