/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarPengurusMasjid;
import entities.PengurusMasjid;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sumurmunding
 */
@WebServlet(name = "SimpanEditPengurusServlet", urlPatterns = {"/simpaneditpengurus"})
public class SimpanEditPengurusServlet extends HttpServlet {

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

        DaftarPengurusMasjid daftar = new DaftarPengurusMasjid();

        String nama = request.getParameter("nama");
        String jabatan = request.getParameter("jabatan");
        String noTelp = request.getParameter("noTelp");
        Long id = Long.parseLong(request.getParameter("id"));

        PengurusMasjid pengurus = daftar.findPengurusMasjid(id);

        if (nama.isEmpty() || jabatan.isEmpty() || noTelp.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorpengurus", "Afwan, data pengurus gagal disimpan. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("pengurus");
            rdp.forward(request, response);

        } else if (!noTelp.matches("[0-9]*")) { //validasi input telepon harus angka
            request.setAttribute("errorpengurus", "Afwan, data pengurus gagal disimpan. Nomor telepon harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("pengurus");
            rdp.forward(request, response);

        } else {
            pengurus.setNama(nama);
            pengurus.setJabatan(jabatan);
            pengurus.setNoTelp(noTelp);
            daftar.editPengurusMasjid(pengurus);
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
