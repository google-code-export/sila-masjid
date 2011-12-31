<%-- 
    Document   : lapout
    Created on : 31 Des 11, 21:14:50
    Author     : Alin
--%>

<%@page import="entities.DaftarLaporan"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entities.Transaksi"%>
<%@page import="java.util.Iterator"%>
<%@page import="entities.Masjid"%>
<%@include file="hometemplate.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%DaftarLaporan lap=(DaftarLaporan)request.getAttribute("lap");%>
<% Masjid masjid=(Masjid)request.getAttribute("masjid");%>
<%Long idMasjid= masjid.getId();%>
<% Iterator iterZkt = (Iterator)request.getAttribute("iterZkt");%>
<%--jumlah pnrmaan zakat--%>
<% Double trmZkt =lap.getJumlah(idMasjid, "21");%>

<%-- detil infak--%>
<% Iterator iterInf = (Iterator)request.getAttribute("iterInf");%>
<%--jumlah pnrmaan infak--%>
<% Double trmInfak = lap.getJumlah(idMasjid, "22");%>

<%-- detil Lain--%>
<% Iterator iterLain = (Iterator)request.getAttribute("iterLain");%>
<%--jumlah pnrmaan lain--%>
<% Double trmLain = lap.getJumlah(idMasjid, "23");%>
<%--jumlah pnrmaan--%>
<% Double trmJum = lap.getJumlah(idMasjid, "2");%>

<!DOCTYPE html>
<html>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%-- JUDUL DI SINI--%> 
        <td width="700" height="32" class="contentheader"><div align="center"><b>LAPORAN PENGELUARAN DANA</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <h2 align="center"><%=masjid.getNmMasjid()%></h2>
                <h4 align="center"><%=masjid.getAlmtMasjid()%></h4>
                <h3 align="center"><%=masjid.getKotaMasjid()%></h3>
                <tr> 
                    <td >&nbsp;</td>
                </tr>

                <tr> 
                    <td width="10%">&nbsp;</td>
                    <th width="10%"><b>TANGGAL</b></th>
                    <th width="30%"><b>URAIAN PENGELUARAN<b></th>
                    <th width="20%" align="right"><b>JUMLAH PENGELUARAN<b></th>
                    <th widht="1%">&nbsp;</th>
                    <th width="25%"><b>PENERIMA DANA<b></th>
                </tr>
               <% while (iterZkt.hasNext()) {%>
               <% Transaksi next = (Transaksi)iterZkt.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td ><%=next.getTran().getNmTrans() %></td>
                    <td width="20%" align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                    <td widht="1%">&nbsp;</td>
                    <td ><%=next.getPen().getNmPenDan()+","+next.getPen().getAlmtPenDan() %></td>
                </tr>
                <%}%>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>Penyaluran Zakat</td>
                    <td width="20%"align="right"> <%=DecimalFormat.getInstance().format(trmZkt)%> </td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                </tr>
               <% while (iterInf.hasNext()) {%>
               <% Transaksi next = (Transaksi)iterInf.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td ><%=next.getTran().getNmTrans() %></td>
                    <td width="20%" align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                    <td>&nbsp;</td>
                    <td ><%=next.getPen().getNmPenDan()+","+next.getPen().getAlmtPenDan() %></td>
                </tr>
                <%}%>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>Penyaluran Infaq/Sedekah</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(trmInfak)%> </td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                </tr>
               <% while (iterLain.hasNext()) {%>
               <% Transaksi next =(Transaksi) iterLain.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td ><%=next.getTran().getNmTrans() %></td>
                    <td width="20%" align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                    <td>&nbsp;</td>
                    <td ><%=next.getDon().getNmDonatur()+","+next.getDon().getAlmtDonatur() %></td>
                </tr>
                <%}%>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>Pengeluaran Lainnya</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(trmLain)%> </td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td >&nbsp;</td>
                    <td align="right"> --------------- </td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td ><b>JUMLAH PENGELUARAN</b></td>
                    <td align="right"> <b><%=DecimalFormat.getInstance().format(trmJum)%></b></td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                </tr>
                <%--ISI SAMPAI SINI--%>
                <tr> 
                    <td width="10%">&nbsp;</td>
                </tr>
            </table></td>
            </tr>
        <tr> 
            <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="700" height="23"></td>
        </tr>
    </table>
        <!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
        <!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
        <div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="422" height="15" border="0"></a></div></td>
    </tr>
</table>
</body>
</html>
