/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarMasjid;
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
 * @author Sumurmunding
 */
public class UbahProfilServlet extends HttpServlet {

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

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nmMasjid = request.getParameter("nmmasjid");
        String alamat = request.getParameter("alamat");
        String kota = request.getParameter("kota");
        String telepon = request.getParameter("telepon");

        //validasi masukan
        if (email.isEmpty() || password.isEmpty() || nmMasjid.isEmpty() || alamat.isEmpty() || kota.isEmpty() || telepon.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Afwan, kolom tidak boleh kosong !");
            RequestDispatcher rdp = request.getRequestDispatcher("ubahprofil");
            rdp.forward(request, response);

        } else if (password.length() < 6) { //validasi panjang password
            request.setAttribute("error", "Afwan (maaf), password minimal 6 karakter");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);


        } else {
            DaftarMasjid daftar = new DaftarMasjid();
            Masjid masjid = new Masjid();

            masjid.setEmail(email);
            masjid.setPassword(password);
            masjid.setNmMasjid(nmMasjid);
            masjid.setAlmtMasjid(alamat);
            masjid.setKotaMasjid(kota);
            masjid.setKotaMasjid(kota);
            daftar.editMasjid(masjid); //menambahkan record ke tabel masjid
            
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
