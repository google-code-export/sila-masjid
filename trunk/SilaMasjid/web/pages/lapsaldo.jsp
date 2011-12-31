<%-- 
    Document   : lapsaldo
    Created on : 30 Des 11, 23:11:31
    Author     : Alin
--%>

<%@page import="entities.Masjid"%>
<%@page import="entities.Transaksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='hometemplate.html' %>
<%@page import="entities.DaftarLaporan"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.lang.Double"%>

<% Masjid masjid=(Masjid)session.getAttribute("masjid");%>
<%Long idMasjid=masjid.getId();%>

<% DaftarLaporan lap = new DaftarLaporan();%>
<%--jumlah pnrmaan zakat--%>
<% Double trmZkt = lap.getJumlah(idMasjid, "11");%>
<%--jumlah pnrmaan infak--%>
<% Double trmInfak = lap.getJumlah(idMasjid, "12");%>
<%--jumlah pnrmaan lain--%>
<% Double trmLain = lap.getJumlah(idMasjid, "13");%>
<%--jumlah pnrmaan--%>
<% Double trmJum = lap.getJumlah(idMasjid, "1");%>
<%--jumlah penyaluran zakat--%>
<% Double klrZkt = lap.getJumlah(idMasjid, "21");%>
<%--jumlah penyaluran infak--%>
<% Double klrInfak = lap.getJumlah(idMasjid, "22");%>
<%--jumlah pengeluaran lain--%>
<% Double klrLain = lap.getJumlah(idMasjid, "23");%>
<%--jumlah pengeluaran--%>
<% Double klrJum = lap.getJumlah(idMasjid, "2");%>
<%Double saldo=trmJum-klrJum;%>
<!DOCTYPE html>
<html>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%-- JUDUL DI SINI--%> 
        <td width="700" height="32" class="contentheader"><div align="center"><b>RINGKASAN LAPORAN DANA</b></div></td>
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
                    <td width="10%">&nbsp;</td>
                </tr>
                <tr> 
                    <td width="20%">&nbsp;</td>
                    <td><b>PENERIMAAN:<b></td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td width="30%">&nbsp;</td>
                    <td width="30%">&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>Penerimaan Zakat</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(trmZkt)%> </td>
                    <td width="30%">&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>Penerimaan Infaq/Sedekah</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(trmInfak)%> </td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>Penerimaan Lainnya</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(trmLain)%> </td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right"> --------------- </td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right"> <b><%=DecimalFormat.getInstance().format(trmJum)%></b></td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td><b>PENGELUARAN:<b></td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td width="30%">&nbsp;</td>
                    <td width="30%">&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>Penyaluran Zakat</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(klrZkt)%> </td>
                    <td width="30%">&nbsp;</td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>Penyaluran Infaq/Sedekah</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(klrInfak)%> </td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>Pengeluaran Lainnya</td>
                    <td align="right"> <%=DecimalFormat.getInstance().format(klrLain)%> </td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right"> --------------- </td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right"> <b><%=DecimalFormat.getInstance().format(klrJum)%></b></td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right"> --------------- </td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td><b>SALDO DANA</b></td>
                    <td align="right"> <b><%=DecimalFormat.getInstance().format(saldo)%></b></td>
                </tr>
                <tr> 
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="right"> ============ </td>
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
