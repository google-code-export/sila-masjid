/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarDonatur;
import entities.Donatur;
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

        String nama = request.getParameter("nama");
        String telepon = request.getParameter("telepon");
        String alamat = request.getParameter("alamat");

        //validasi masukan
        if (nama.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Afwan, kolom tidak boleh kosong !");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/donator.jsp");
            rdp.forward(request, response);

        } 

         else {
            DaftarDonatur daftar = new DaftarDonatur();
            Donatur donatur = new Donatur();

            donatur.setNmDonatur(nama);
            donatur.setAlmtDonatur(alamat);
            donatur.setTelpDonatur(telepon);
            daftar.addDonatur(donatur); //menambahkan record ke tabel masjid

            HttpSession session = request.getSession(true);//setelah registrasi berhasil, langsung login
            session.setAttribute("nama", donatur.getNmDonatur());
            session.setAttribute("telepon", donatur.getTelpDonatur());
            session.setAttribute("alamat", donatur.getAlmtDonatur());
            response.sendRedirect("profil");
        }
        /*  try {
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ProcessRegisterServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ProcessRegisterServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        } finally {
        out.close();
        }*/
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
