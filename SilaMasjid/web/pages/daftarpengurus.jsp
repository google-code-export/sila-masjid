<%-- 
    Document   : daftarpengurus
    Created on : 02-Jan-2012, 22:15:23
    Author     : Sumurmunding
--%>

<%@page import="entities.Masjid"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarPengurusMasjid"%>
<%@page import="entities.PengurusMasjid"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% Long id = (Long) session.getAttribute("id");%>
<% Masjid masjid = (Masjid) session.getAttribute("masjid");%>
<!DOCTYPE html>
<%@include file='hometemplate2.html' %>
<% DaftarPengurusMasjid daftar = new DaftarPengurusMasjid();%>
<% List<PengurusMasjid> listPengurus = daftar.getPengurusMasjids(id);%>
<% Iterator<PengurusMasjid> iterator = listPengurus.iterator();%>
<html>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
            <tr> 
                <%-- JUDUL DI SINI--%> 
                <td width="700" height="32" class="contentheader"><div align="center"><b>DAFTAR PENGURUS <%=masjid.getNmMasjid().toUpperCase()%></b></div></td>
            </tr>
            <tr> 
                <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
            </tr>
            <tr> 
                <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                        <%-- ISI MULAI SINI---%>
                        <tr>
                            <td width="7%">&nbsp;</td>
                            <td width="5%">No.</td>
                            <th width="35%" align="left">Nama Pengurus</th>
                            <th width="30%" align="left">Jabatan</th>
                            <th width="20%" align="left">No. Telepon</th>
                        </tr>
                        <% int no = 0;%>
                        <% while (iterator.hasNext()) {%>
                        <% no++;%>
                        <% PengurusMasjid next = iterator.next();%>
                        <tr>
                            <td width="7%">&nbsp;</td>
                            <td width="5%" align="center"><%=no%></td>
                            <td width="35%" align="left"><%=next.getNama()%></td>
                            <td width="30%" align="left"><%=next.getJabatan()%></td>
                            <td width="20%" align="left"><%=next.getNoTelp()%></td>
                        </tr>
                        <%}%>
                        <tr>
                            <td width="7%">&nbsp;</td>
                            <td width="5%" align="center">&nbsp;</td>
                            <td width="35%" align="left">&nbsp;</td>
                            <td width="30%" align="left">&nbsp;</td>
                            <td width="20%" align="right">&nbsp;</td>
                        </tr>
                        <tr>
                            <td width="7%">&nbsp;</td>
                            <td width="5%" align="center">&nbsp;</td>
                            <td width="35%" align="left">&nbsp;</td>
                            <td width="30%" align="left">&nbsp;</td>
                            <td width="20%" align="right"><a href="masjids">Kembali</a></td>
                        </tr>

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


