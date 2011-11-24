/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author: Sumurmunding
 * 
 */
package servlets;

import entities.DaftarPengurusMasjid;
import entities.Masjid;
import entities.PengurusMasjid;
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
 * @author Sumurmunding
 */
public class SimpanPengurusServlet extends HttpServlet {

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
        Long idMasjid = masjid.getId();

        String nama = request.getParameter("nama");
        String jabatan = request.getParameter("jabatan");
        String noTelp = request.getParameter("noTelp");

        //validasi masukan
        if (nama.isEmpty() || jabatan.isEmpty() || noTelp.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorpengurus", "Afwan, data pengurus gagal disimpan. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("pengurus");
            rdp.forward(request, response);

        } else if (!noTelp.matches("[0-9]*")) { //validasi input telepon harus angka
            request.setAttribute("errorpengurus", "Afwan, data pengurus gagal disimpan. Nomor telepon harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("pengurus");
            rdp.forward(request, response);

        } else {
            //request.setAttribute("pesanberhasil", "Alhamdulillah ya, data pengurus berhasil disimpan.");
            DaftarPengurusMasjid daf = new DaftarPengurusMasjid();
            PengurusMasjid pengurus = new PengurusMasjid();

            pengurus.setIdMasjid(idMasjid);
            pengurus.setNama(nama);
            pengurus.setJabatan(jabatan);
            pengurus.setNoTelp(noTelp);

            daf.addPengurusMasjid(pengurus);
            
        }
        try {
            response.sendRedirect("pengurus");

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
