/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarPenerimaDana;
import entities.PenerimaDana;
import entities.Masjid;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yooganz
 */
public class InputPenerimaDanaServlet extends HttpServlet {

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
        Long idMasjid=masjid.getId();
        
        Long id = null;
        if (request.getParameter("id")!=null)
        {
            id=Long.parseLong(request.getParameter("id"));
        }
        
        String nmPenDan=request.getParameter("nmPenDan");
        String almtPenDan=request.getParameter("almtPenDan");
        String notelpPenDan=request.getParameter("notelpPenDan");
        
        DaftarPenerimaDana daftar = new DaftarPenerimaDana();
        PenerimaDana pendan = new PenerimaDana();
        
        pendan.setIdMasjid(idMasjid);
        pendan.setNmPenDan(nmPenDan);
        pendan.setAlmtPenDan(almtPenDan);
        pendan.setNotelpPenDan(notelpPenDan);
                
        if (daftar.check(id)==false)
        {
            daftar.addPenerimaDana(pendan);
        }
        else
        {
            daftar.editPenerimaDana(pendan);
        }        
        try {
            response.sendRedirect("penerimadana");
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InputPenerimaDanaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InputPenerimaDanaServlet at " + request.getContextPath () + "</h1>");
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