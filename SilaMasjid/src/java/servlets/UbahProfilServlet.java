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
        HttpSession session = request.getSession(); 
        Masjid masjid = (Masjid) session.getAttribute("loged");
        Long id=masjid.getId();
        
        DaftarMasjid dafMasjid = new DaftarMasjid();
        
        //String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nmMasjid = request.getParameter("nmmasjid");
        String alamat = request.getParameter("alamat");
        String kota = request.getParameter("kota");
        String telepon = request.getParameter("telepon");

        //Long id = Long.parseLong(request.getParameter("id"));
       
        //Masjid masjid = dafMasjid.findMasjid(id);

        request.setAttribute("ubahmasjid", masjid);

        //validasi masukan
        if (password.isEmpty() || nmMasjid.isEmpty() || alamat.isEmpty() || kota.isEmpty() || telepon.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorprofil", "Afwan (maaf), ubah profil masjid gagal. Semua kolom tidak boleh kosong !");
            RequestDispatcher rdp = request.getRequestDispatcher("profil");
            rdp.forward(request, response);

        } else if (password.length() < 6) { //validasi panjang password
            request.setAttribute("errorprofil", "Afwan (maaf), password minimal 6 karakter");
            RequestDispatcher rdp = request.getRequestDispatcher("profil");
            rdp.forward(request, response);
            
        }else if(!telepon.matches("[0-9]*")){ //validasi input telepon harus angka
            request.setAttribute("errorprofil", "Afwan (maaf), nomor telepon harus berupa angka. Proses ubah profil gagal.");
            RequestDispatcher rdp = request.getRequestDispatcher("profil");
            rdp.forward(request, response);

        } else {         
            masjid.setPassword(password);
            masjid.setNmMasjid(nmMasjid);
            masjid.setAlmtMasjid(alamat);
            masjid.setKotaMasjid(kota);
            masjid.setTelpMasjid(telepon);
            dafMasjid.editMasjid(masjid); //mengubah record ke tabel masjid
            session.setAttribute("nmMasjid",masjid.getEmail()+'/'+masjid.getNmMasjid());
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
