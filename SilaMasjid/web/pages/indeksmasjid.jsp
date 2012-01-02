<%-- 
    Document   : indeksmasjid
    Created on : 02-Jan-2012, 13:45:37
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarMasjid"%>
<%@page import="entities.Masjid"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@include file='hometemplate2.html' %>
<% DaftarMasjid daftar = new DaftarMasjid();%>
<% List<Masjid> masjid = daftar.getMasjids();%>
<% Iterator<Masjid> iterator = masjid.iterator();%>
<!DOCTYPE html>
<html>
    <%--JUDUL DI SINI--%>
    <td width="700" height="32" class="contentheader"><div align="center"><b>INDEKS MASJID</b></div></td>
</tr>
<tr> 
    <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
</tr>
<tr> 
    <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
            <%--ISI MULAI DI SINI--%>
            <form action="" method="post">
                <tr>
                    <td width="7%">&nbsp;</td>
                    <th width="5%" align="center">No.</th>
                    <th width="20%" align="left">Nama Masjid</th>
                    <th width="25%" align="left">Alamat</th>
                    <th width="15%" align="left">Kota</th>
                    <th width="18%" align="left">Nomor Telepon</th>
                    <th width="10%" align="center">Pengurus</th>
                </tr>
                <% int no = 0;%>
                <% while (iterator.hasNext()) {%>
                <% no++;%>
                <% Masjid next = iterator.next();%>
                <tr>
                    <td width="7%">&nbsp;</td>
                    <td width="5%" align="center"><%=no%></td>
                    <td width="20%" align="left"><%=next.getNmMasjid()%></td>
                    <td width="25%" align="left"><%=next.getAlmtMasjid()%></td>
                    <td width="15%" align="left"><%=next.getKotaMasjid()%></td>
                    <td width="18%" align="left"><%=next.getTelpMasjid()%></td>
                    <td width="10%" align="center"><a href="daftarpengurus?id=<%=next.getId()%>">Pengurus</a></td>
                </tr>
                <%}%>     
                <tr><td>&nbsp;</td></tr>
            </form>
            <%--ISI SAMPAI DI SINI--%>
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
