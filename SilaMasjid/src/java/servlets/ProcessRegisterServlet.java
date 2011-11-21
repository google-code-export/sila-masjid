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
public class ProcessRegisterServlet extends HttpServlet {

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
        String ulangiPassword = request.getParameter("ulangipassword");

        //validasi masukan
        if (email.isEmpty() || password.isEmpty() || ulangiPassword.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Afwan, kolom tidak boleh kosong !");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (email.indexOf("@") == -1 && email.indexOf(".") == -1) {//validasi format email
            request.setAttribute("error", "Afwan (maaf), format email yang dimasukkan salah");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (password.length() < 6) { //validasi panjang password
            request.setAttribute("error", "Afwan (maaf), password minimal 6 karakter");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (!password.equals(ulangiPassword)) {//validasi password dan konfirm password (sama/tidak)
            request.setAttribute("error", "Afwan (maaf), password dan konfirmasi password yang dimasukkan salah");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);
            
        }else {
            DaftarMasjid daftar = new DaftarMasjid();
            Masjid masjid = new Masjid();

            masjid.setEmail(email);
            masjid.setPassword(password);
            daftar.addMasjid(masjid); //menambahkan record ke tabel masjid

            HttpSession session = request.getSession(true);//setelah registrasi berhasil, langsung login
            session.setAttribute("idMasjid", masjid.getId());
            session.setAttribute("nama", masjid.getNmMasjid());
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
