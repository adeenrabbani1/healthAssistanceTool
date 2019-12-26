/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.HospitalDAO;
import DAO.ScoreDAO;
import entity.Hospital;
import entity.Standard;
import DAO.StandardDAO;
import DAO.SurveyorDAO;
import entity.HospitalScore;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Surveyor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adeen
 */
@WebServlet(name = "surveyorController", urlPatterns = {"/surveyorController"})
public class surveyorController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String command = isSurveyor(request, response);

        // String s = (String)request.getParameter("hosp");
        PrintWriter out = response.getWriter();

        if (command == null) {
            command = "Home";
        }

        switch (command) {
            case "Home": {

                break;
            }

            case "HISTORY": {

                //fetches already scored Hospitals by perticular surveyor
                HttpSession session = request.getSession(true);
                Surveyor s = (Surveyor) session.getAttribute("user");
                List<Hospital> p = null;
                HospitalDAO obj = new HospitalDAO();
                try {
                    p = obj.fetchScoredHospitals(s.getSurv_id());
                } catch (Exception ex) {
                    Logger.getLogger(surveyorController.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("values", p);
                RequestDispatcher rd = request.getRequestDispatcher("surveyor/history.jsp");
                rd.forward(request, response);

            }
            case "ME": {

                //serve the profile page for surveyor
                RequestDispatcher rd = request.getRequestDispatcher("surveyor/Myprofile.jsp");
                rd.forward(request, response);

                break;
            }
            case "CHANGE": {
                HttpSession session = request.getSession(true);
                Surveyor s = (Surveyor) session.getAttribute("user");
                //code to change the status of the surveyor!
                //redirects to the same page with flash message

                SurveyorDAO p = new SurveyorDAO();
                try {
                    p.changeStatus(s.getSurv_id(), s.getStatus());
                } catch (Exception ex) {
                    Logger.getLogger(surveyorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Surveyor tempS = null;
                try {
                    tempS = p.fetchSurv();
                } catch (Exception ex) {
                    Logger.getLogger(surveyorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.removeAttribute("user");
                session.setAttribute("user", tempS);
                session.setAttribute("flash", "status");
                response.sendRedirect("surveyor/Myprofile.jsp");
//             RequestDispatcher rd = request.getRequestDispatcher("surveyor/Myprofile.jsp");
//             rd.forward(request, response);
//            

                break;
            }

            case "SCORE": {

                HttpSession session = request.getSession(true);
                session.setAttribute("hospId", request.getParameter("hosp"));

                try {
                    List<Standard> standards = new StandardDAO().fetchStandards();
                    out.print(standards);
                    request.setAttribute("values", standards);
                } catch (Exception ex) {
                    Logger.getLogger(surveyorController.class.getName()).log(Level.SEVERE, null, ex);
                }

                RequestDispatcher rd = request.getRequestDispatcher("surveyor/surveyorScore.jsp");
                rd.forward(request, response);

                break;
            }
        }

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

        String command = isSurveyor(request, response);
        PrintWriter out = response.getWriter();

        out.print("The id is " + command);

//        HttpSession session = request.getSession(true);
//        Surveyor p = (Surveyor)session.getAttribute("serveyor");
//        out.print("The name is "+ p.getName());
        if (command == null) {
            command = "Home";
        }

        switch (command) {
            case "Home": {

                break;
            }
            case "surveyorDashboard": {

                HttpSession session = request.getSession(true);
                Surveyor s = (Surveyor) session.getAttribute("user");
                try {
                    List<Hospital> hospitals = new HospitalDAO().fetchAssignedHospital(s.getSurv_id());
                    request.setAttribute("surveyorHospitals", hospitals);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                RequestDispatcher rd = request.getRequestDispatcher("surveyor/dashboard.jsp");
                rd.forward(request, response);

                break;
            }
            case "SUBMIT-SCORE": {

                HttpSession session = request.getSession(true);
                out.print(session.getAttribute("hospId"));

                String id = (String) session.getAttribute("hospId");
                List<HospitalScore> scoreList = new ArrayList<>();
                try {
                    List<Standard> standards = new StandardDAO().fetchStandards();

                    //getting all the scores from the forms
                    for (int i = 0; i < standards.size(); i++) {
                        HospitalScore p = new HospitalScore();
                        p.setRecommendation(request.getParameter(standards.get(i).getTitle() + "com"));
                        p.setScore(request.getParameter(standards.get(i).getTitle()));
                        p.setHospitalId(id);
                        p.setStandardId(standards.get(i).getId());
                        scoreList.add(p);
                    }

                    ScoreDAO p = new ScoreDAO();
                    p.addScores(scoreList);
                    Surveyor s = (Surveyor) session.getAttribute("user");
                    //  List<Hospital> hospitals = new HospitalDAO().fetchAssignedHospital(s.getSurv_id());
                    //request.setAttribute("surveyorHospitals", hospitals);
                    // Dispatch to the dashboard with flash messages
                    HospitalDAO hdao = new HospitalDAO();
                    hdao.updateStatus(Integer.parseInt(id), s.getSurv_id());
                    session.setAttribute("flash", "scored");
                    response.sendRedirect("surveyor/dashboard.jsp");
//                   
//                  RequestDispatcher rd = request.getRequestDispatcher("surveyor/dashboard.jsp");
//                  rd.forward(request, response);

                } catch (Exception ex) {
                    Logger.getLogger(surveyorController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }

        }

    }

    public String isSurveyor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = null;
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") != null) {

            if ((session.getAttribute("user").getClass().getName().equals("entity.Surveyor"))) {
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
