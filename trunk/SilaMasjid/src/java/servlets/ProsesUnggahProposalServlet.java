/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarProposal;
import entities.Proposal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sumurmunding
 */
public class ProsesUnggahProposalServlet extends HttpServlet {

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

        String nama = request.getParameter("nama");
        String alamat = request.getParameter("alamat");
        String noTelp = request.getParameter("noTelp");
        String email = request.getParameter("email");
       // Integer besarDana = Integer.parseInt(request.getParameter("besarDana"));
        String dana = request.getParameter("besarDana");
        String judul = request.getParameter("judul");
        String detailProposal = request.getParameter("detailProposal");

        if (nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty() || email.isEmpty() || dana.isEmpty() || judul.isEmpty() || detailProposal.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorproposal", "Afwan, Proposal gagal diunggah. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("proposal");
            rdp.forward(request, response);

        } else if (!noTelp.matches("[0-9]*")) { //validasi input telepon harus angka
            request.setAttribute("errorproposal", "Afwan, Proposal gagal diunggah. Nomor telepon harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("proposal");
            rdp.forward(request, response);

        } else if (!dana.matches("[0-9]*")) { //validasi input telepon harus angka
            request.setAttribute("errorproposal", "Afwan, Proposal gagal diunggah. Besar dana harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("proposal");
            rdp.forward(request, response);
        } else if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
            request.setAttribute("errorproposal", "Afwan (maaf), format email salah");
            RequestDispatcher rdp = request.getRequestDispatcher("proposal");
            rdp.forward(request, response);
        } else {
            try {
                DaftarProposal daftar = new DaftarProposal();
                Proposal proposal = new Proposal();
                
                Integer besarDana = Integer.parseInt(dana);
                proposal.setNama(nama);
                proposal.setAlamat(alamat);
                proposal.setNoTelp(noTelp);
                proposal.setEmail(email);
                proposal.setBesarDana(besarDana);
                proposal.setJudul(judul);
                proposal.setDetailProposal(detailProposal);
                daftar.addProposal(proposal);
                response.sendRedirect("proposal");
            } finally {
                out.close();
            }
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
