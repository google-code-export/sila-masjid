/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarPengurusMasjid;
import entities.PengurusMasjid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Sumurmunding
 */
public class HapusPengurusServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //HttpSession sessionedit = request.getSession();
            DaftarPengurusMasjid daftar = new DaftarPengurusMasjid();
            Long id = Long.parseLong(request.getParameter("id"));
            PengurusMasjid pengurus = daftar.findPengurusMasjid(id);
        /*   edit 1 des 2011 int pilihan = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus '"+pengurus.getNama()+ "' dari Daftar Pengurus Masjid?",
                    JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

            if (pilihan == JOptionPane.YES_OPTION) {*/
                daftar.deletePengurusMasjid(id);
                request.setAttribute("sukses","Hapus data berhasil");
                response.sendRedirect("pengurus");
           /* }
            else{
                response.sendRedirect("pengurus");
              //  RequestDispatcher rdp = request.getRequestDispatcher("pages/pengurus.jsp");
                //rdp.forward(request, response);
            }*/
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(HapusKodeTransaksiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(HapusKodeTransaksiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
