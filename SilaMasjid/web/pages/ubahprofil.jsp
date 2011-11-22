<%-- 
    Document   : register
    Created on : 14-Nov-2011, 10:57:46
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarMasjid"%>
<%@page import="entities.Masjid"%>
<% Masjid masjid=(Masjid)request.getAttribute("masjid");%>
<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<html>
    
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%-- JUDUL DI SINI--%> 
        <td width="452" height="32" class="contentheader"><div align="center"><b>PROFIL MASJID</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="452" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <form action="ubahprofilmasjid" method="post" >
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Email</td><td><input type="text" name="email" value="<%=masjid.getEmail()%>" style="width: 160px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Password</td><td><input type="password" name="password" value="<%=masjid.getPassword()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Nama Masjid</td><td><input type="text" name="nmmasjid" value="<%=masjid.getNmMasjid()%>"style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Alamat</td><td><input type="text" name="alamat" value="<%=masjid.getAlmtMasjid()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Kota</td><td><input type="text" name="kota" value="<%=masjid.getKotaMasjid()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Telepon</td><td><input type="text" name="telepon" value="<%=masjid.getTelpMasjid()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td >&nbsp;</td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td></td><td><input type="submit" value="Simpan" ></td>
                    </tr>
                    <tr>
                        <td >&nbsp;</td>
                    </tr>
                    
                </form>
                <%--ISI SAMPAI SINI--%>
            </table></td>
    </tr>
    <tr> 
        <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="452" height="23"></td>
    </tr>
</table>
<!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
<!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
<div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="422" height="15" border="0"></a></div></td>
</tr>
</table>
</body>
</html>

