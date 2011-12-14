<%-- 
    Document   : register
    Created on : 02-Nov-2011, 23:37:46
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarMasjid"%>
<%@page import="entities.Masjid"%>
<!DOCTYPE html>
<%@include file='hometemplate2.html' %>
<html>
    <tr> 
        <%--JUDUL DI SINI--%>
           <td width="452" height="32" class="contentheader"><div align="center"><b>FORM REGISTRASI</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="452" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%--ISI MULAI DI SINI--%>
                <form action="processregister" method="post" >

                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Email</td><td><input type="text" name="email" style="width: 160px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Password</td><td><input type="password" name="password" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Ulangi Password</td><td><input type="password" name="ulangipassword" style="width: 120px"></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>&nbsp;</td><td><input type="submit" value="Register" >&nbsp;&nbsp;<input type="reset" value="Reset"></td>
                    </tr>
                    <tr><td colspan="3" align="center"><label align="center"><font color="red"><b>${error}</b></font></label></td></tr>
                </form>

                <%--SISI SAMPAI DI SINI--%>
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

