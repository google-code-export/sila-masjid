/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarDonatur;
import entities.Donatur;
import entities.Masjid;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danke
 */
public class InputDonaturServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(); 
        Masjid masjid = (Masjid) session.getAttribute("loged");
        Long idMasjid=masjid.getId();
        
        String nmDonatur=request.getParameter("nmDonatur");
        String telpDonatur=request.getParameter("telpDonatur");
       
        String almtDonatur=request.getParameter("almtDonatur");
        
        DaftarDonatur daftar=new DaftarDonatur();
        Donatur dona=new Donatur();
        
        if (nmDonatur.isEmpty() || telpDonatur.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Afwan (maaf), untuk kolom nama dan telepon harus diisi !");
            RequestDispatcher rdp = request.getRequestDispatcher("donator");
            rdp.forward(request, response);

        }
        else{
        dona.setIdMasjid(idMasjid);
        dona.setNmDonatur(nmDonatur);
        dona.setTelpDonatur(telpDonatur);
        dona.setAlmtDonatur(almtDonatur);
        //simpan
        daftar.addDonatur(dona);
        }
        try {
           response.sendRedirect("donator");
     
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
