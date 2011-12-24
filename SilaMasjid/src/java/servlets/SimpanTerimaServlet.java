/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.DaftarKodeTransaksi;
import entities.DaftarDonatur;
import entities.DaftarRekening;
import entities.DaftarTransaksi;
import entities.KodeTransaksi;
import entities.Masjid;
import entities.Donatur;
import entities.Rekening;
import entities.Transaksi;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alin
 */
public class SimpanTerimaServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Masjid masjid = (Masjid) session.getAttribute("loged");
        Long idMasjid = masjid.getId();

        String dateString = request.getParameter("tgl");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date tglTran = dateFormat.parse(dateString);
        String idTrans = request.getParameter("idTrans");
        String idPen = request.getParameter("idDon");
        String idRek = request.getParameter("idRek");
        String ket = request.getParameter("nmTrans");
        String jmlTran = request.getParameter("jumlah");
        String flag = "1";

        //validasi masukan
        if (idTrans.isEmpty() || idPen.isEmpty() || idRek.isEmpty() || jmlTran.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorTerima", "Afwan, data penerimaan gagal disimpan, ada kotak belum diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("terima");
            rdp.forward(request, response);
        } else if (!jmlTran.matches("[0-9]*")) { //validasi input jumlah harus angka
            request.setAttribute("errorTerima", "Afwan, data penerimaan gagal disimpan. Jumlah harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("terima");
            rdp.forward(request, response);
        } else {
            //request.setAttribute("pesanberhasil", "Alhamdulillah ya, data penerimaan berhasil disimpan.");
            DaftarTransaksi daf = new DaftarTransaksi();
            Transaksi terima = new Transaksi();

            DaftarKodeTransaksi dafKd = new DaftarKodeTransaksi();
            KodeTransaksi tran = dafKd.getKodeTransaksi(Long.parseLong(request.getParameter("idTrans")));

            DaftarRekening dafRek = new DaftarRekening();
            Rekening rek = dafRek.getRekening(Long.parseLong(request.getParameter("idRek")));

            DaftarDonatur dafPen = new DaftarDonatur();
            Donatur pen = dafPen.getDonatur(Long.parseLong(request.getParameter("idPen")));

            terima.setMasjid(masjid);
            terima.setTglTran(tglTran);
            terima.setJmlTran(Double.parseDouble(jmlTran));
            terima.setKet(ket);
            terima.setTran(tran);
            terima.setRek(rek);
            terima.setDon(pen);
            terima.setFlag(flag);

            daf.addTransaksi(terima);

        }
        try {
            response.sendRedirect("terima");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SimpanTerimaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SimpanTerimaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
