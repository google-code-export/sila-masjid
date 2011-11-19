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
 * @author alin
 */
public class LoginServlet extends HttpServlet {

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

        DaftarMasjid masjids = new DaftarMasjid();
        Masjid masjid = masjids.getMasjid(email, password);

        if (email.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorLogin", "Afwan (maaf) Email atau Password Tidak Boleh Kosong");
            RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
            rdp.forward(request, response);
         //validasi format email   
        }else if (email.indexOf("@")==-1||email.indexOf(".")==-1){
            request.setAttribute("errorLogin","Afwan (maaf), format email salah");
            RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
            rdp.forward(request, response);
        } else if (masjids.check(email, password) == false) {
            request.setAttribute("errorLogin", "Afwan (maaf), email atau password salah");
            RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
            rdp.forward(request, response);
        } else {

            HttpSession session = request.getSession(true);
            session.setAttribute("loged", masjid);
            session.setAttribute("nmMasjid",masjid.getEmail()+'/'+masjid.getNmMasjid());

            RequestDispatcher rdp = request.getRequestDispatcher("pages/aplikasi.jsp");
            rdp.forward(request, response);
        }
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
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
