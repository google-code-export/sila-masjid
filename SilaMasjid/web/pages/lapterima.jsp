<%-- 
    Document   : lapterima
    Created on : 28 Des 11, 16:42:03
    Author     : Alin
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="entities.Transaksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='aplikasitemplate.html' %>
<%@page import="entities.DaftarLaporan"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.lang.Double"%>

<% DaftarLaporan lap = new DaftarLaporan();%>

<%-- detil zakat--%>
<% List<Transaksi> zakats = lap.getTransByKd(idMasjid, "11");%>
<% Iterator<Transaksi> iterZkt = zakats.iterator();%>
<%--jumlah pnrmaan zakat--%>
<% Double trmZkt = lap.getJumlah(idMasjid, "11");%>

<%-- detil infak--%>
<% List<Transaksi> infaks = lap.getTransByKd(idMasjid, "12");%>
<% Iterator<Transaksi> iterInf = infaks.iterator();%>
<%--jumlah pnrmaan infak--%>
<% Double trmInfak = lap.getJumlah(idMasjid, "12");%>

<%-- detil Lain--%>
<% List<Transaksi> lains = lap.getTransByKd(idMasjid, "13");%>
<% Iterator<Transaksi> iterLain = lains.iterator();%>
<%--jumlah pnrmaan lain--%>
<% Double trmLain = lap.getJumlah(idMasjid, "13");%>
<%--jumlah pnrmaan--%>
<% Double trmJum = lap.getJumlah(idMasjid, "1");%>

<!DOCTYPE html>
<html>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%-- JUDUL DI SINI--%> 
        <td width="700" height="32" class="contentheader"><div align="center"><b>LAPORAN PENERIMAAN DANA</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td width="10%">&nbsp;</td>
                    <td width="30%"><b>PENERIMAAN ZAKAT:<b></td>
                </tr>
               <% while (iterZkt.hasNext()) {%>
               <% Transaksi next = iterZkt.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td ><%=next.getTran().getNmTrans() %></td>
                    <td width="20%" align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                </tr>
                <%}%>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td width="20%">&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>Penerimaan Zakat</td>
                    <td >&nbsp;</td>
                    <td width="20%"align="right"> <%=DecimalFormat.getInstance().format(trmZkt)%> </td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td width="10%">&nbsp;</td>
                    <td width="30%"><b>PENERIMAAN INFAQ/SEDEKAH:<b></td>
                </tr>
               <% while (iterInf.hasNext()) {%>
               <% Transaksi next = iterInf.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td ><%=next.getTran().getNmTrans() %></td>
                    <td width="20%" align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                </tr>
                <%}%>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td width="20%">&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>Penerimaan Infaq/Sedekah</td>
                    <td >&nbsp;</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(trmInfak)%> </td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td width="10%">&nbsp;</td>
                    <td width="30%"><b>PENERIMAAN LAINNYA:<b></td>
                </tr>
               <% while (iterLain.hasNext()) {%>
               <% Transaksi next = iterLain.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td ><%=next.getTran().getNmTrans() %></td>
                    <td width="20%" align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                </tr>
                <%}%>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right">----------------</td>
                    <td width="20%">&nbsp;</td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td>Penerimaan Lainnya</td>
                    <td >&nbsp;</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(trmLain)%> </td>
                    <td >&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                    <td align="right"> --------------- </td>
                </tr>
                <tr> 
                    <td >&nbsp;</td>
                    <td>&nbsp;</td>
                    <td ><b>JUMLAH PENERIMAAN</b></td>
                    <td >&nbsp;</td>
                    <td align="right"> <b><%=DecimalFormat.getInstance().format(trmJum)%></b></td>
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
