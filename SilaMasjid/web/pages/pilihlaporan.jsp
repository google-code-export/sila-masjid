<%-- 
    Document   : pilihlaporan
    Created on : 30 Des 11, 22:43:01
    Author     : Alin
--%>

<%@page import="entities.Masjid"%>
<%@page import="entities.DaftarMasjid"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%@include file='hometemplate.html' %>
<% DaftarMasjid daftar=new DaftarMasjid();%>
<% List<Masjid> trans=daftar.getMasjids();%>
<% Iterator<Masjid> iterator = trans.iterator();%>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%--JUDUL DI SINI--%>
        <td width="700" height="32" class="contentheader"><div align="center"><b>LAPORAN DANA MASJID</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <form action="" method="post" >
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td width="20%">Masjid</td>
                        <td><select name="idMas">
                                <option value="">Pilih Masjid</option>
                                <% while (iterator.hasNext()) {%>
                                <% Masjid next = iterator.next();%>
                                <option value=<%=next.getId()%>><%=next.getNmMasjid() + " - " + next.getAlmtMasjid()+","+next.getKotaMasjid()%></option>
                                <%}%>
                        </select></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td >Pilih Laporan:</td>
                        <td><a href="lap_saldo"><font color="blue">Laporan Ringkas</font></a></td>
                       </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                         <td width="10%">&nbsp;</td>
                        <td><a href="lap_in"><font color="blue">Laporan Penerimaan</font></a></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                         <td width="10%">&nbsp;</td>
                        <td><a href="lap_out"><font color="blue">Laporan Pengeluaran</font></a></td>
                     </tr>
                    <tr><td>&nbsp;</td></tr>
                </form>
   
                <%--ISI SAMPAI SINI--%>
                    <tr><td>&nbsp;</td></tr>
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
