<%-- 
    Document   : editdonatur
    Created on : Nov 21, 2011, 10:37:28 AM
    Author     : danke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="entities.Berita"%>
<%@include file='aplikasitemplate.html' %>
<% Berita dona =(Berita)request.getAttribute("berita");%>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%--JUDUL DI SINI--%>
        <td width="700" height="32" class="contentheader"><div align="center"><b>EDIT BERITA</b></div></td>
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
                        <td>Judul</td>
                        <td><input type="text" name="judul" value="<%=dona.getJudul().substring(0)%>"style="width: 160px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td >Isi Berita</td><td><textarea name="isiBerita" cols="100" rows="30"><%=dona.getIsiBerita().substring(0)%></textarea></td>
                    </tr>
                    
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>&nbsp;</td><td><input type="button" value="Simpan" onclick="this.form.action='simpan_edit_berita';this.form.submit();">
                            <input type="reset" value="Batal" onclick="this.form.action='batal_berita';this.form.submit();"></td>
                        <td><input type="button" value="Hapus" style="background-color:#c00; color:#fff;" onclick="this.form.action='hapus_berita';this.form.submit();"></td>
                    </tr>
                    <tr><td colspan="6" align="center"><label align="center"><font color="red"><b>${errorberita}</b></font></label></td></tr>
                    <tr><td>&nbsp;</td></tr>
                </form>
   
                <%--ISI SAMPAI SINI--%>

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
