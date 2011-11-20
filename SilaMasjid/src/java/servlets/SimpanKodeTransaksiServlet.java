/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarKodeTransaksi;
import entities.KodeTransaksi;
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
 * @author alin
 */
public class SimpanKodeTransaksiServlet extends HttpServlet {

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
        if (request.getParameter("id")!=null){
            id=Long.parseLong(request.getParameter("id"));
        }
        String klp=request.getParameter("kelompok");
        String jns=request.getParameter("jenis");
        String kdTrans=klp+jns;
        String nmTrans=request.getParameter("nmTrans");
        
        DaftarKodeTransaksi daftar=new DaftarKodeTransaksi();
        KodeTransaksi kode=new KodeTransaksi();
        
        kode.setIdMasjid(idMasjid);
        kode.setKdTrans(kdTrans);
        kode.setNmTrans(nmTrans);
        //simpan
        //jika id sudah ada, edit (update), jika belum maka add
        if (daftar.check(id)==false){
            daftar.addKodeTransaksi(kode);
        }else{
            daftar.editKodeTransaksi(kode);
        } 
        
        try {
           response.sendRedirect("kode");
     
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
