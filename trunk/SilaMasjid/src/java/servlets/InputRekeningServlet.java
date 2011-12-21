/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarRekening;
import entities.Rekening;
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
 * @author yooganz
 */
public class InputRekeningServlet extends HttpServlet {

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

       // Long id = null;
      //  id = Long.parseLong(request.getParameter("id"));

        /*if (request.getParameter("id")!=null)
        {
        id=Long.parseLong(request.getParameter("id"));
        }*/

        String noRek = request.getParameter("noRek");
        String nmRek = request.getParameter("nmRek");
        String bank = request.getParameter("bank");

        if (noRek.isEmpty() || nmRek.isEmpty() || bank.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorrekening", "Afwan, data rekening gagal disimpan. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("rekening");
            rdp.forward(request, response);

        } else if (!noRek.matches("[0-9]*")) { //validasi input telepon harus angka
            request.setAttribute("errorrekening", "Afwan, data rekening gagal disimpan. Nomor rekening harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("rekening");
            rdp.forward(request, response);

        } else {

            DaftarRekening daftar = new DaftarRekening();
            Rekening rek = new Rekening();

            rek.setIdMasjid(idMasjid);
            rek.setNoRek(noRek);
            rek.setNmRek(nmRek);
            rek.setBank(bank);

            daftar.addRekening(rek);
        }
        /*if (daftar.check(id)==false)
        {
        daftar.addRekening(rek);
        }
        else
        {
        daftar.editRekening(rek);
        } */

        try {
            response.sendRedirect("rekening");

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
