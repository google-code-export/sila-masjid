/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarLaporan;
import entities.DaftarMasjid;
import entities.Masjid;
import entities.Transaksi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alin
 */
public class LapOutServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);

        DaftarLaporan lap = new DaftarLaporan();
        request.setAttribute("lap", lap);

        String idmas = request.getParameter("idMasjid");

        if (idmas.isEmpty()) {
            request.setAttribute("errormas", "Silakan Antum (Anda) pilih masjid dulu");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/pilihlaporan.jsp");
            rdp.forward(request, response);
        } else {
            Long idMasjid = Long.parseLong(request.getParameter("idMasjid"));
            DaftarMasjid daf = new DaftarMasjid();
            Masjid masjid = daf.findMasjid(idMasjid);
            request.setAttribute("masjid", masjid);

//detil zakat
            List< Transaksi> zakats = lap.getTransByKd(idMasjid, "21");
            Iterator< Transaksi> iterZkt = zakats.iterator();
            request.setAttribute("iterZkt", iterZkt);

//detil infak
            List< Transaksi> infaks = lap.getTransByKd(idMasjid, "22");
            Iterator< Transaksi> iterInf = infaks.iterator();
            request.setAttribute("iterInf", iterInf);
//detil Lain
            List< Transaksi> lains = lap.getTransByKd(idMasjid, "23");
            Iterator< Transaksi> iterLain = lains.iterator();
            request.setAttribute("iterLain", iterLain);
        }

        try {

            RequestDispatcher rdp = request.getRequestDispatcher("pages/lapout.jsp");
            rdp.forward(request, response);

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
