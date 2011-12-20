/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarProposal;
import entities.DaftarMasjid;
import entities.Masjid;
import entities.Proposal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Sumurmunding
 */
public class ProsesSetujuProposal extends HttpServlet {

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
        String cek[] = request.getParameterValues("cek");
        String jsp = "";

        try {
            if (cek == null) {
                //JOptionPane.showMessageDialog(null, "Kegiatan tidak ada yang dipilih");
                request.setAttribute("pesan","Anda belum memilih proposal yang akan disetujui");
                jsp = "pages/daftarproposal.jsp";
            } else {
                for (int i = 0; i < cek.length; i++) {
                    long id = Long.parseLong(cek[i]);
                    DaftarProposal daftar = new DaftarProposal();
                    Proposal proposal = daftar.getProposal(id);
                    Date tglSetuju = new Date(new java.util.Date().getTime());

        //            proposal.setIdMasjid(idMasjid);
                    proposal.setTglSetuju(tglSetuju);
                    proposal.setSetuju(true);
                    proposal.setMasjid(masjid);
                    daftar.editProposal(proposal);
                }
                jsp = "pages/daftarproposal.jsp";
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
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
