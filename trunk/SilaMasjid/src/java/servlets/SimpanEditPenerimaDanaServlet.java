/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarPenerimaDana;
import entities.PenerimaDana;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yooganz
 */
public class SimpanEditPenerimaDanaServlet extends HttpServlet {

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
        
        HttpSession sessionedit=request.getSession();
        
        DaftarPenerimaDana daftar = new DaftarPenerimaDana();

        String nmPenDan = request.getParameter("nmPenDan");
        String almtPenDan = request.getParameter("almtPenDan");
        String notelpPenDan = request.getParameter("notelpPenDan");
       
        PenerimaDana pendan = (PenerimaDana)sessionedit.getAttribute("pendan");
        
        if (nmPenDan.isEmpty() || almtPenDan.isEmpty() || notelpPenDan.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorpendan", "Afwan, data penerima dana gagal disimpan. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("penerimadana");
            rdp.forward(request, response);

        } else if (!notelpPenDan.matches("[0-9]*")) { //validasi input nomor telepon harus angka
            request.setAttribute("errorpendan", "Afwan, data penerima dana gagal disimpan. Nomor telepon harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("penerimadana");
            rdp.forward(request, response);

        } else {
            pendan.setNmPenDan(nmPenDan);
            pendan.setAlmtPenDan(almtPenDan);
            pendan.setNotelpPenDan(notelpPenDan);
            daftar.editPenerimaDana(pendan);
            response.sendRedirect("penerimadana");
        }        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SimpanEditPenerimaDanaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SimpanEditPenerimaDanaServlet at " + request.getContextPath () + "</h1>");
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
